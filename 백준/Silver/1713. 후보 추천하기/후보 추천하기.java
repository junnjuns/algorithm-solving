import java.util.*;
import java.io.*;


public class Main
{
    
    static class Pick{
        int number;
        int cnt;
        int time;
        
        public Pick(int number, int cnt, int time){
            this.number = number;
            this.cnt = cnt;
            this.time = time;
        }
    }
    
    
    static int n;
    static int recommendCnt;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		   
		n = Integer.parseInt(br.readLine());
		recommendCnt = Integer.parseInt(br.readLine());
		
		ArrayList<Pick> album = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int idx = 0; idx < recommendCnt; idx++){
		    
		    int now = Integer.parseInt(st.nextToken());
		    boolean find = false;
		    
		    for(Pick p : album){
                if(p.number == now){
                    p.cnt += 1;
                    find = true;
                    break;
                }
            }
		    
		    if(!find){
		        if(album.size() < n){
		            album.add(new Pick(now, 1, idx));
		        }
		        else{
		            Pick remove = album.get(0);
		            
		            for(Pick p : album){
		                if(p.cnt < remove.cnt){ //추천 횟수 비교
		                    remove = p;
		                }
		                else if(p.cnt == remove.cnt){
		                    if(p.time < remove.time){ //시간 비교
		                        remove = p;
		                    }
		                }
		            }
		            
		            album.remove(remove);
		            album.add(new Pick(now, 1, idx));
		        }
		    }
		    
		}
		
		List<Integer> result = new ArrayList<>();
        for(Pick p : album){
            result.add(p.number);
        }
        
        Collections.sort(result);
        
        for(int num : result){
            bw.write(num + " ");
        }	
		
		
		bw.flush();
		bw.close();
		
	}
}
