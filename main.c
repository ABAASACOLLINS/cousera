/*
 * CALCULATOR5.c
 *
 * Created: 15/09/2024 15:20:16
 * Author : iNVESTOR
 */ 
#define F_CPU 1000000UL
#include <avr/io.h>
#include <util/delay.h>
#include <stdlib.h>  // For itoa (integer to ASCII conversion)


// Define LCD control pins
#define RS PB0
#define RW PB1
#define E  PB2

// Latch function to trigger LCD
void latch(void)
{
	PORTB |= (1 << E);  // Enable = 1
	_delay_ms(1);
	PORTB &= ~(1 << E); // Enable = 0
	_delay_ms(1);
}

// Function to send command to LCD
void send_command(uint8_t cmd)
{
	PORTA = cmd;
	PORTB &= ~(1 << RS);  // RS = 0 for command
	PORTB &= ~(1 << RW);  // RW = 0 for write
	latch();
	_delay_ms(1);
}

// Function to send data to LCD
void send_data(char data)
{
	PORTA = data;
	PORTB |= (1 << RS);   // RS = 1 for data
	PORTB &= ~(1 << RW);  // RW = 0 for write
	latch();
	_delay_ms(1);
}

// Function to display a string on LCD
void display_string(const char *str)
{
	while (*str)
	{
		send_data(*str++);
	}
}

int main(void)
{
	// Set DDRs
	DDRB = 0xFF;  // PORTB as output for control lines
	DDRA = 0xFF;  // PORTA as output for LCD data lines
	DDRD = 0x0F;  // Lower nibble of PORTD as output (rows), upper nibble as input (columns)

	// Initialize LCD
	send_command(0x38);  // 8-bit mode, 2-line display
	send_command(0x0C);  // Display ON, cursor OFF
	send_command(0x01);  // Clear display
	send_command(0x06);  // Entry mode set: increment, no shift

	char keys[4][4] = {
		{'7', '8', '9', '/'},
		{'4', '5', '6', '*'},
		{'1', '2', '3', '-'},
		{'C', '0', '=', '+'}
	};

	char key;
	int operand1 = 0, operand2 = 0;
	char operator = 0;
	char result_str[16];  // To hold the result as a string

	while (1)
	{
		// Scan keypad
		for (unsigned char row = 0; row < 4; row++)
		{
			PORTD = ~(1 << row);  // Set one row low at a time
			_delay_ms(10);        // Small delay for stability

			for (unsigned char col = 0; col < 4; col++)
			{
				if (!(PIND & (1 << (col + 4))))  // Check if column is pressed
				{
					key = keys[row][col];  // Capture the pressed key

					if (key >= '0' && key <= '9')  // If key is a digit
					{
						if (operator == 0)  // If no operator is selected, update operand1
						{
							operand1 = (operand1 * 10) + (key - '0');
						}
						else  // If operator is selected, update operand2
						{
							operand2 = (operand2 * 10) + (key - '0');
						}
						send_data(key);  // Display the key pressed
					}
					else if (key == 'C')  // Clear everything
					{
						operand1 = 0;
						operand2 = 0;
						operator = 0;
						send_command(0x01);  // Clear display
					}
					else if (key == '=' && operator != 0)  // Perform calculation on '='
					{
						int result = 0;

						switch (operator)
						{
							case '+': result = operand1 + operand2; break;
							case '-': result = operand1 - operand2; break;
							case '*': result = operand1 * operand2; break;
							case '/': 
								if (operand2 != 0)
									result = operand1 / operand2;
								else
									display_string("Err");  // Handle divide by 0 error
								break;
						}
						
						if (operand2 != 0 || operator != '/')  // Only display result if no error
						{
							send_command(0x01);  // Clear display
							itoa(result, result_str, 10);  // Convert result to string
							display_string(result_str);  // Display result
						}
						
						// Reset after calculation
						operand1 = 0;
						operand2 = 0;
						operator = 0;
					}
					else  // If an operator is pressed
					{
						operator = key;  // Store operator
						send_data(key);  // Display operator
					}

					// De-bouncing: wait until the key is released
					while (!(PIND & (1 << (col + 4))))
					{
						// Do nothing, just wait for the key to be released
					}
					_delay_ms(200);  // Small delay to avoid multiple detections
				}
			}
		}
	}
}