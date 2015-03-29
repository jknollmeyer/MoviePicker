#include "MoviePicker.h"

using namespace std;

class userinput{
    
    int genre;
    /* Vector of 23 booleans (they are actually integers because they need to be added later I know that's ugly) with true at an index if user selected corresponding genre below:
     Short   1
     Drama   2
     Comedy  3
     Documentary 4
     Adult   5
     Action  6
     Romance 7
     Thriller    8
     Animation   9
     Family  10
     Horror  11
     Crime   12
     Music   13
     Adventure   14
     Fantasy 15
     Sci-Fi  16
     Mystery 17
     Biography   18
     History 19
     Sport   20
     Musical 21
     War 22
     Western 23
     */
    
    bool animated; //yes 1, no 0, don't care 1 from pull down menu
    
    vector<string> actors (5);
    
    vector<string> directors (5);
    
    time runtime;
    
public:
    
    userinput(bool actors_input, bool directors_input, bool keywords_input,bool maxruntime_input);
    
    int getGenre();
    
    bool getAnimated();
    
    vector<string> getActors();
    
    vector<string> getDirectors();
    
    int getRuntime();
    
    void setGenre(int usergenre);
    
    void setAnimated(bool want_animated);
    
    void setActors(vector<string> useractors);
    
    void setDirectors(vector<string> userdirectors);
    
    void setRuntime(int hours, int minutes);
};
