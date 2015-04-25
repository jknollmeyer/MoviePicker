import "MoviePicker.java";
import "userinput.java";
import java.util.Scanner;
import java.lang.Object*;


/* setting window input */ 
void applySettings();
movie decisionMaker();

int main(){
	MoviePicker.initialfileopen();
	int num_watchers = new int;
	ArrayList<userinput> watchers;

	for (int i= 0; i < num_watchers; i++){
        watchers.add(userinput()); /* all inputs given by this user uses overloaded constructor in userinput.h*/
        
    }

    applySettings();
    decisionMaker(userinput watchers[]);
}

void applySettings(){
	PrintWriter working_movielist = new PrintWriter("Working_MovieList.txt");
	string line;
	string[6] ratings = {"G","PG","PG-13","R","NR","NC-17"};
	string last_line;

	 /* this loop applies max rating */
	for (int i = 0; i < 6; i++){
        
        while (mpaa.ready()) {
        	if (i != 0){
        		last_line = line;
        	}
            line = mpaa.readLine();
            if (settings.max_rating[i]){
                if (line.contains(ratings[i]){
                    working_movielist.println(last_line);
                }
            }
        }
    }
    
    mpaa.close();
    working_movielist.close();

    /* the working list now has lines in the following format:
     MV: Kill Bill: Vol. 1 (2003) */
    
    
    

    Path movielist_path = Path.get(./"Working_MovieList.txt");
    InputStream movielist = new Files.newInputStream(movielist_path);

    PrintWriter edited_movielist = new PrintWriter("edited_movielist.txt");
    Scanner scan = new Scanner(movielist);
    string word;
    string[] words;
    int[] numbers;
    string buffer;
    int numbers_idx = 0;
    Scanner buffer_scan = new Scanner();
    int year;

    /* this loop gets rid of MV: crap */
    while (movielist.ready()){
    	word = scan.next();
    	if (word == "MV:"){
    	}
    	else{
    		buffer = scan.nextLine();
    		edited_movielist.print(buffer);
    	}
    }

    InputStream new_movielist


}
