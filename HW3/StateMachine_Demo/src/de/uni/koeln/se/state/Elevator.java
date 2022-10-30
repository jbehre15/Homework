package de.uni.koeln.se.state;


public class Elevator{
	
	public static int current_Floor=5;
	int dest_Floor;
	
	private Elv_States State = new Elv_States();
	
	public Elevator (int dest_floor)
	{
		this.dest_Floor=dest_floor;
	System.out.println("*** Destination floor is: "+ dest_Floor);
	this.State.Current_State = this.State.Idle;
	System.out.println(this.State.Current_State);
	
	if(current_Floor > this.dest_Floor) {
		go_down();
	} else if( current_Floor < this.dest_Floor) {
		go_up();
	} else {
		exit();
	}

	}

	private void arrive_atFloor() {
		
		this.State.Current_State = this.State.Idle;
		System.out.println(this.State.Current_State);
		exit();
		
	}
	
	private void go_down() {
		this.State.Current_State = this.State.Moving_down;
		System.out.println(this.State.Current_State);
		current_Floor--;
		if(current_Floor > this.dest_Floor) {
			go_down();
		} else {
			arrive_atFloor();
		}
	}
	
	private void go_up() {
		this.State.Current_State = this.State.Moving_up;
		System.out.println(this.State.Current_State);
		current_Floor++;
		if(current_Floor < this.dest_Floor) {
			go_up();
		} else {
			arrive_atFloor();
		}
	}
	
	private void exit() {
		System.out.println("Exiting elevator!");
	}

	
}
