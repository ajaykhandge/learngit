class Meeting{
    int start;
    int end;
    int pos;
    
    public Meeting(int start,int end,int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class SortMeetings implements Comparator<Meeting>{
    @Override
    
    public int compare(Meeting a, Meeting b){
        
        if(a.end< b.end)
            return -1;   //let it be as it is
        else if(a.end> b.end)  //reverse the pairs
            return 1;
        else if(a.pos < b.pos)  //if equal then sort on based of position 
            return -1;
        return 1;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        //array to hold the meetings based on start time
        
        ArrayList<Meeting> meet  = new ArrayList<Meeting>();
        for(int i=0;i<start.length;i++)
            meet.add(new Meeting(start[i],end[i],i+1));
            
        //sort the meetings based on start time
        
        Collections.sort(meet,new SortMeetings());
        
        int countmeet = 1;
        int endflag = meet.get(0).end; 
        for(int i=1;i<meet.size();i++){
            if(meet.get(i).start > endflag)
               { endflag = meet.get(i).end;
                countmeet++;}
        }
        
        return countmeet;
        
    }
    
    public static void main(String [] args){
        System.out.println("Enter the total number of meetings");
        int n = sc.nextInt();
        
        int start[] = new int[n];
        int end[] = new int[n];
        
        System.out.println("Enter the start and endtime for each meeting");
        
        for(int i=0;i<n;i++){
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        
        int count = maxMeetings(start,end,n);
        System.out.pritln("The maximum meeting that can happen is: "+ count);
    }
}
