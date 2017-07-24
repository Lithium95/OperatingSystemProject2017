package algorithm;

import Items.Job;
import Items.ProcessList;
import presentation.ReportWriter;

public class SRTF extends ReportWriter{
	private ProcessList mainList;
	private Job job;
	
	public SRTF(ProcessList list){
		super("Report.txt");
		mainList = list;
	}
	
	public int run(ProcessList list){
		try{
			list.OrderedByShortRemain();
			for(int i=0;i<list.size();i++){
			
			for(int j=0;j<list.size();j++){
				try{
					if(mainList.getJob(j) == list.getJob(j)){
						if(j+1 <= mainList.size()){
							job = mainList.getJob(j+1);
						}else{
							job =mainList.getJob(j);
						}
					}
				}catch(Exception e){
					System.out.println("J+1 triggered");
					continue;
				}
			}
				if(list.getJob(i).getArrivalTime() > list.getCurrentTime()){
					list.setCurrentTime(list.getJob(i).getArrivalTime());
				}
				list.getJob(i).setStartTime(list.getCurrentTime());
				
				if(list.getJob(i).getBurstTime() > job.getArrivalTime()){
					list.getJob(i).setEndTime(list.getCurrentTime() + list.getJob(i).getBurstTime());
					list.getJob(i).setRemainingTime(list.getJob(i).getBurstTime() - job.getArrivalTime());
					list.setCurrentTime(list.getJob(i).getEndTime());
				}else{
					list.getJob(i).setEndTime(list.getCurrentTime() + list.getJob(i).getBurstTime());
					list.getJob(i).setRemainingTime(0);
					list.setCurrentTime(list.getJob(i).getEndTime());
					list.getJob(i).Finished = true;
				}
				
				System.out.print(list.getJob(i).getProcessId());
				super.WriteReport(String.format(Integer.toString(list.getJob(i).getProcessId())));
				if(list.getJob(i).getProcessId() >= 10){
					System.out.printf("%13s",list.getJob(i).getArrivalTime());
					super.WriteReport(String.format("%13s",list.getJob(i).getArrivalTime()));
				}else{
					System.out.printf("%14s",list.getJob(i).getArrivalTime());
					super.WriteReport(String.format("%14s",list.getJob(i).getArrivalTime()));
				}
				System.out.printf("%15s",list.getJob(i).getBurstTime());
				System.out.printf("%17s",list.getJob(i).getStartTime());
				System.out.printf("%14s",list.getJob(i).getEndTime());
				super.WriteReport(String.format("%15s",list.getJob(i).getBurstTime()));
				super.WriteReport(String.format("%17s",list.getJob(i).getStartTime()));
				super.WriteReport(String.format("%14s",list.getJob(i).getEndTime()));
				if(list.getJob(i).getRemainTime() > 0 ){
					System.out.printf("%19s",list.getJob(i).getRemainTime());
					super.WriteReport(String.format("%19s",list.getJob(i).getRemainTime()));
				}else if(list.getJob(i).getRemainTime() == 0 ){
					System.out.printf("%19s",0);
					super.WriteReport(String.format("%19s",0));
					list.getJob(i).Finished=true;
				}
				System.out.printf("%19s",list.getJob(i).getProcessType() +"\n");
				super.WriteReport(String.format("%19s",list.getJob(i).getProcessType() +"\r\n"));

				list.getJob(i).setBurstTime(list.getJob(i).getRemainTime());
				if(list.getJob(i).Finished == true){
					list.removeJob(i);
				}
			}
		}catch(Exception e){
			
		}
		return list.getCurrentTime();
	}
}
	
