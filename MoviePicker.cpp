#include "MoviePicker.h"
#include "userinput.h"
#include <alogrithm>
#include <cmath>

using namespace std;


void applySettings();
void decisionMaker();


int main(){
    
    initialfileopen();
    
    new settings settingspane; // from settings window in GUI
    
    new int num_watchers; // first thing that should be set in the GUI
    
    new vector<userinput> watchers (num_watchers);
    
    
    // now let's fill the vector with valuable user input information
    for (int i= 0; i < num_watchers; i++){
        watchers[i] = userinput(); /* all inputs given by this user uses overloaded constructor in userinput.h*/
        
    }
    decisionMaker(userinput watchers[]);
    
}

void applySettings(){
    // let's first apply our settings to our search
    ofstream working_movielist;
    working_movielist.open("Possible_Movies.txt");
    
    string line;
    string[6] ratings = {"G","PG","PG-13","R","NR","NC-17"};
    
    /* this loop applies max rating */
    
    for (int i = 0; i < 6; i++){
        
        while (!mpaa.eof()) {
            getline(mpaa, line);
            if (settings.max_rating[i]){
                if (line.find(ratings[i]) != string::npos) {
                    working_movielist << mpaa.getline(curLine - 1) <<endl;
                }
            }
        }
    }
    
    mpaa.close();
    /* the working list now has lines in the following format:
     MV: Kill Bill: Vol. 1 (2003) */
    
    
    /* this loop can deletes entries released to early */
    ofstream working_movielist1;
    working_movielist1.open("working_movielist.txt");
    
    int file_line = 0;
    string title;
    int year;
    while (!working_movielist.eof()){
        getline(working_movielist, line);
        sscanf(line, "MV: %s (%d)", title, &year)
        if (year < settings.earliest_release){
            working_movielist1 << title << " " << "(" << year << ")" <<endl;
        }
    }
    /* we now have movies valid according to seetings in the following format:
     Kill Bill: Vol. 1 2003 */
    /* now we begin to get user inputs */
    
}

void decisionMaker(watchers[]){
    // the mode of the genre inputs is the genre we want
    int number = watchers[0].genre;
    int genre_mode = number;
    int count = 1;
    int countgenre_mode = 1;
    
    for (int i = 0; i < num_watchers; i++){
        if (watchers[i].genre == number){
            count++;
        }
        
        else{
            if (count > countgenre_mode){
                countgenre_mode = count;
                genre_mode = number;
            }
            count = 1;
            number = watchers[i].genre;
        }
    }
    string genre_mode_string;
    switch (genre_mode){
        case 1:
            genre_mode_string = "Short";
            break;
        case 2:
            genre_mode_string = "Drama";
            break;
        case 3:
            genre_mode_string = "Comedy";
            break;
        case 4:
            genre_mode_string = "Documentary";
            break;
        case 5:
            genre_mode_string = "Adult";
            break;
        case 6:
            genre_mode_string = "Action";
            break;
        case 7:
            genre_mode_string = "Romance";
            break;
        case 8:
            genre_mode_string = "Thriller";
            break;
        case 9:
            genre_mode_string = "Animation";
            break;
        case 10:
            genre_mode_string = "Family";
            break;
        case 11:
            genre_mode_string = "Horror";
            break;
        case 12:
            genre_mode_string = "Crime";
            break;
        case 13:
            genre_mode_string = "Music";
            break;
        case 14:
            genre_mode_string = "Adventure";
            break;
        case 15:
            genre_mode_string = "Fantasy";
            break;
        case 16:
            genre_mode_string = "Sci-Fi";
            break;
        case 17:
            genre_mode_string = "Mystery";
            break;
        case 18:
            genre_mode_string = "Biography";
            break;
        case 19:
            genre_mode_string = "Histroy";
            break;
        case 20:
            genre_mode_string = "Sport";
            break;
        case 21:
            genre_mode_string = "Musical";
            break;
        case 22:
            genre_mode_string = "Musical";
            break;
        case 23:
            genre_mode_string =  "War";
            break;
        case 24:
            genre_mode_string = "Western";
            break;
    
    
    string line2
    
    ofstream out("out.txt");
    
    while( getline(genre,line) ) { // this deletes movies of improper genre
        if(line2.find(genre_mode_string) != npos){
            out << line << endl;
        }
    }
    
    // delete the original file
    remove("genre.list");
    rename("out.txt","genre.list");
    
    
    while (!(genre.eof() || working_movielist1.eof())) {
        getline(working_movielist, line);
        // going to search the working movie list titles in the genre file to and delete them if their genre is not the genre_mode
        getline(genre,line2);
        
        ofstream out("outfile.txt");
        
        while( working_movielist1.eof() ) { // this deletes movies of improper genre
            getline(working_movielist1,line)
            if(line2.find(line) != npos){
                out << line << endl;
            }
        }
        
        genre.close();
        // close the original file
        remove("working_movielist.txt"); // edits working movielist
        rename("outfile.txt","working_movielist.txt");
    }
    
    int line_counter = 0;
    while ( ! working_movielist1.eof()){    // this loop counts # of lines in a file
        getline(working_movielist1,line);
        line_counter++;
    }
    
    int randolinepick = (rand() % line_counter) + 1; // picks a random line in the working movielist file to select movie
    
    string mytitle;
    string myyear;
    for (int i = 0; i < randolinepick; i++){
        getline(working_movielist1,line);
    }
    
    sscanf(line, "%s (%d)", mytitle, &myyear)
    
    tonights_movie.title = mytitle;
    tonights_movie.year = myyear;

}
