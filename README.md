# Figuro

## Overview
Figuro is an application that helps you create geometrical shapes and calculate their parameters. It handles 2D figures (Triangle, Circle, Rectangle) with a friendly command-line interface.

## Features

### Figure Types
- **Triangle**: Defined by three sides
- **Circle**: Defined by radius
- **Rectangle**: Defined by two sides

### Operations
- Calculate perimeter for any figure
- Convert any figure to its string representation
- Create figures from different sources (Random, STDIN, File)
- List all figures in your collection
- Delete a figure from the collection
- Duplicate (clone) any figure in the collection
- Save your figure collection to a file

### String Representation Format
Figures are represented as strings in the format: `[figure type] [parameters...]`

Examples:
- `triangle 10 20 30` - A triangle with sides 10, 20, and 30
- `circle 5` - A circle with radius 5
- `rectangle 10 20` - A rectangle with sides 10 and 20

## Design Patterns Used
- **Factory Pattern**: For creating figures from strings
- **Abstract Factory Pattern**: For choosing between different input methods
- **Prototype Pattern**: For cloning figures

## How to Use

### Main Menu
When you start Figuro, you'll see the main menu with these options:
- `create` - Add new figures
- `list` - Display all figures
- `delete` - Remove a figure
- `duplicate` - Clone a figure
- `save` - Store figures to a file
- `exit` - Exit the application

### Creating Figures
When you select `create`, you can choose from three methods:
1. `random` - Generate random figures
2. `stdin` - Read figures from keyboard
3. `file` - Read figures from a file

You'll then specify how many figures you want to create.

#### When using stdin input:
Type each figure on a new line in this format:
```
triangle 10 20 30
circle 5
rectangle 10 20
```

#### When using file input:
Enter the file path when prompted. The file should contain figures in the same format as stdin input, one per line.

### Managing Your Collection
- Use `list` to see all figures in your collection
- Use `delete` to remove a figure (you'll be asked for its number)
- Use `duplicate` to clone a figure (you'll be asked for its number)
- Use `save` to store your collection to a file (you'll be asked for the file path)

## Example Usage

```
Welcome to Figuro
The app that helps you create geometrical shapes and calculate their parameters :)

Main Menu:
> create - Add new figures
> list - Display all figures
> delete - Remove a figure
> duplicate - Clone a figure
> save - Store figures to a file
> exit - Exit the application

Enter command: create

Choose a method for creating figures:
> random - Generate random figures
> stdin - Read figures from keyboard
> file - Read figures from a file

Enter method: stdin
Input Format Instructions:
Type figure type + measurements, each on a new line
Examples:
triangle 10 20 30    (a triangle with sides 10, 20, and 30)
circle 5            (a circle with radius 5)
rectangle 10 20     (a rectangle with sides 10 and 20)

Enter figures (one per line):
How many figures do you want to create? 3
triangle 3 4 5
Created: triangle 3 4 5
circle 10
Created: circle 10
rectangle 7 12
Created: rectangle 7 12
Created 3 figures.

Main Menu:
> create - Add new figures
> list - Display all figures
> delete - Remove a figure
> duplicate - Clone a figure
> save - Store figures to a file
> exit - Exit the application

Enter command: list

List of all figures:
1: triangle 3 4 5
2: circle 10
3: rectangle 7 12

Main Menu:
> create - Add new figures
> list - Display all figures
> delete - Remove a figure
> duplicate - Clone a figure
> save - Store figures to a file
> exit - Exit the application

Enter command: duplicate
Enter the number of the figure to duplicate: 1
Duplicated: triangle 3 4 5

Main Menu:
> create - Add new figures
> list - Display all figures
> delete - Remove a figure
> duplicate - Clone a figure
> save - Store figures to a file
> exit - Exit the application

Enter command: list

List of all figures:
1: triangle 3 4 5
2: circle 10
3: rectangle 7 12
4: triangle 3 4 5

Main Menu:
> create - Add new figures
> list - Display all figures
> delete - Remove a figure
> duplicate - Clone a figure
> save - Store figures to a file
> exit - Exit the application

Enter command: save
Enter file path to save figures: figures.txt
Figures saved to figures.txt

Main Menu:
> create - Add new figures
> list - Display all figures
> delete - Remove a figure
> duplicate - Clone a figure
> save - Store figures to a file
> exit - Exit the application

Enter command: exit
Thank you for using Figuro. Goodbye!
```

## Error Handling
Figuro handles various errors gracefully:
- Invalid figure parameters (negative values, impossible triangles, double overflow, etc.)
- Invalid input format
- File not found or access errors
- Invalid commands
- Invalid figure numbers when deleting or duplicating

If an error occurs while creating figures, you'll be asked if you want to continue or abort.
