package Items;

public class List {
	
	private MyArrayList mainList;
	private int number;
	private int currentTime = 0; // current simulation time
	
	/**
     * create an empty list with size for a specific number of jobs
     * @param number is the number of jobs
     */
	public List(int number){
		mainList = new MyArrayList(number);
	    this.number = number; 
	}
	
	/**
     * @return current time in simulation
     */
	public int getCurrentTime(){
		return currentTime;
	}
	
	/**
     * @param time is the current time in simulation
    */
	public void setCurrentTime(int time){
		currentTime = time;
	}
	
	/**
    * @param num is the number of the job in the queue
    * @return selected job
    */
	public Job getJob(int num){
	    return mainList.get(num);
	}
	
	/**
     * add job to the end of the queue
     * @param job is the job to be added
    */
	public void addJob(Job job){
		mainList.add(job);  
	}
	
	/**
     * replace the job at a specific place of the list
     * @param i is the place of job to be replaced
     * @param job is the new job to replace with
     */
	public void set(int i , Job job){
		mainList.set(i, job);
	}
	
	/**
    * @return the size-1 of the array list 
    */
	public int size(){
		return mainList.lenght();
	}
	
	/**
     * check if the queue is empty
     * @return true if empty
    */
	public boolean isEmpty(){
		return (mainList.isEmpty());
	}
	
	/**
     * order the jobs inside the list by arrive time
    */
	public void OrderedByArrive(){
		for(int i=0 ; i<mainList.lenght() ; i++){
			for(int j=i+1 ; j<mainList.lenght() ;j++){
				Job j1 = mainList.get(i);
	            Job j2 = mainList.get(j);
	            if(j2.isFirst(j1)){
	            	mainList.set(i, j2);
	                mainList.set(j, j1);
	            }
	       }
	   }
	}
	
	/**
    * order the jobs inside the list by shortest burst time
    */
	public void OrderedByShortest(){
		for(int i=0 ; i<mainList.lenght() ; i++){
			for(int j=i+1 ; j<mainList.lenght() ;j++){
				Job j1 = mainList.get(i);
				Job j2 = mainList.get(j);
				if(j2.isShort(j1)){
					mainList.set(i, j2);
					mainList.set(j, j1);
	            }
	        }
	    }
	}
	
	/**
    * order the jobs inside the queue by the shortest remaining time
    */
	public void OrderedByShortRemain(){
		for(int i=0 ; i<mainList.lenght() ; i++){
			for(int j=i+1 ; j<mainList.lenght() ;j++){
				Job j1 = mainList.get(i);
				Job j2 = mainList.get(j);
				if(j2.isShortRemain(j1)){
					mainList.set(i, j2);
					mainList.set(j, j1);
	           }
	       }
	   }
	}
	
	/**
    * Show queue content (every job details)
    */
	public void showList(){
		if(mainList.isEmpty()){
			System.out.println("Empty Queue"); 
		}else{
			for(int i=0 ; i<mainList.lenght() ; i++){
				Job temp = mainList.get(i);
				System.out.println("ProcessId:\t"+temp.getProcessId());
				System.out.println("ProcessType:\t"+temp.getProcessType());
//				System.out.println("Priority:\t"+temp.getPriority());
		     	System.out.println("ArrivalTime:\t"+temp.getArrivalTime());
		     	System.out.println("BurstTime:\t"+temp.getBurstTime()+"\n");	
		    }
		}
	}
}