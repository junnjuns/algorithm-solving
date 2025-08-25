import java.util.*;
import java.io.*;

public class Main
{
    static class Person implements Comparable<Person>{
        String name;
        int day;
        int month;
        int year;
        
        public Person(String name, int day, int month, int year){
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
        
        public int compareTo(Person o){
            if(this.year == o.year){
                if(this.month == o.month){
                    return this.day - o.day;
                }
                else{
                    return this.month - o.month;
                }
            }
            return this.year - o.year;
        }
    }
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Person> list = new ArrayList<>();
        
        for(int idx = 0; idx < n; idx++){
            st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            
            list.add(new Person(name, day, month, year));
        }
        
        
        Collections.sort(list);
        
        bw.write(list.get(list.size() - 1).name+"\n");
        bw.write(list.get(0).name);
        
	    bw.flush();
	    bw.close();
	}
    
}
