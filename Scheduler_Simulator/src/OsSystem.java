import java.util.ArrayList;
import java.util.*;
public class OsSystem {
	
	
	//an array List which contains Processes
	private ArrayList<Process> processes;
	
	//a variable that holds the number of processes
	int total_processes;
	
	//simulation parameters
	int max_arrival_time;
	int average;
	int standard_deviation;
	
	
	
	
	//constructor
	public OsSystem(int k, int avg, int sd, int total_p) {
		
		processes = new ArrayList<Process>();
		
		max_arrival_time = k;
		average = avg;
		standard_deviation = sd;
		total_processes = total_p;
		
		
		//fill the processes ArrayList
		fill_processes();
		
		}//end of constructor
	
	
	
	//function deletes all processes and refills the procees array list
	public void refill() {
		processes = new ArrayList<Process>();
		fill_processes();
	}//end of refill
	
	
	//FIFO Scheduler
	public double fifo_scheduler() {
		
		int current_time =-1;
		
		while (!all_done()) {
			
			current_time+=1;
			
			
		}
		
		return 1.1;
		
	}//end of fifo_scheduler()
	
	
	
	
	
	
	
	
	
	//this function fills the processes with random 
	private void fill_processes() {
		
		for (int i=0; i<processes.size(); i++) {
			
			Process p = new Process(i, gaussian_random(average, standard_deviation));
			
			p.set_arrival_time(generate_arrival_time(average));
			if (p.get_arrival_time()==0)
					p.set_active(true);
			
			p.set_remaining_cpu_time(p.get_total_cpu_time());
			
			p.set_turnaround_time(-1);
			
			processes.add(p);
		
			}
	
	}//end of fill_processes
	
	
	
	
	//Rick############################################################################################################
	
	
	//returns a random integer from Gaussian distribution with mean=average and standard deviation=standard_deviation
	private int gaussian_random(int average, int standard_deviation) {
			Random ran = new Random();
		return (int)ran.nextGaussian() * standard_deviation + average;
	}
	
	//returns a random integer between 0 and max_arrival_time
	// Range of Math.random -> 0.0 - 1.0
	// 0.0 * (max - min) + min => min
	// 1.0 * (max - min) + min => max - min + min => max
	private int generate_arrival_time(int average) {
		return (int)(Math.random()*(average));
	}
	
	//Rick###############################################################################################################
	
	
	//this function returns true if all the processes are finished the execution
	private boolean all_done() {
		
		boolean result=true;
		
		for (int i=0; i<processes.size(); i++) {
			if (!processes.get(i).is_done())
				return false;
		}
		
		return result;
		
	}//end of all_done
	
	
	

}//end of OsSystem class
