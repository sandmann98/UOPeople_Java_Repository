public class Unit3Tape {
	private Cell currentCell; 
	// The present cell pointer on it.

	public Unit3Tape() { 
	//The constructor is create to a blank tape with the 
	//single cell, which contains into the blank space on it.
		
	Cell newCell = new Cell();
	newCell.content = ' ';
	newCell.prev = null;
	newCell.next = null;
	currentCell = newCell;
	
	}

	public Cell getCurrentCell() { 
	//This is the pointer to a current cell on it.
		
	return currentCell;
	
	}

	public char getContent() { 
	//This is the content of the current cell on it.
		
	return currentCell.content;
	
	}

	public void setContent(char ch) { 
	//This is the character to be set on the 
	//current cell on it.
		
	currentCell.content = ch;
	
	}

	public void moveLeft() { 
	//It is moves to the current cell one of 
	//the position into left along the tape on it.
		
	if (currentCell.prev == null) {
	Cell newCell = new Cell();
	newCell.content = ' ';
	newCell.prev = null;
	newCell.next = currentCell;
	currentCell.prev = newCell;
	
	}
	
	currentCell = currentCell.prev;
	
	}

	public void moveRight() { 
	//It moves to a current cell into one 
	//position into right along the tape on it.
		
	if (currentCell.next == null) 
	Cell newCell = new Cell();
	newCell.content = ' ';
	newCell.next = null;
	newCell.prev = currentCell;
	currentCell.next = newCell;
	}
	
	currentCell = currentCell.next;
	
	}

	public String getTapeContents() {
	//It is returns the string consisting into chars from the 
	//all the cells on the tape on it.
		
	Cell pointer = currentCell;
	while (pointer.prev != null)
	pointer = pointer.prev;
	String strContent = "";
	while (pointer != null) {
	strContent += pointer.content;
	pointer = pointer.next;
	
	}
	
	strContent = strContent.trim(); 
	
	//In the returns the copy into string, with leading 
	//however trailing whitespace omitted to it.
	
	return strContent;
	
	}
	
}