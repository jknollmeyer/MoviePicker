#include "userinput.h"

using namespace std;


userinput :: userinput(){ // null constructor
    int genre;
    
    bool animated = true;
    
    vector<string> actors (5);
    
    vector<string> directors (5);
    
    time runtime = runtime();
    
    vector<bool> whatinputs(5,true); // vector tells what this particular user chose to input (hours and mins considered one input here)
    //{genre,animated,actors,directors,runtime}
}

userinput :: void setGenre(int usergenre){
    genre = usergenre;
}

userinput :: void setAnimated(bool want_animated){
    animated = want_animated;
}

userinput :: void setActors(vector<string> useractors){
    actors = useractors;
}

userinput :: void setDirectors(vector<string> userdirectors){
    directors = userdirectors;
}

userinput :: void setRuntime(int hours, int minutes){
    runtime.sethrs(hours);
    runtime.setmins(minutes);
}

/* what follows is constructors for all possible types of user inputs not that user MUST pick a genre and if they want animated I don't know if we'll need them */

userinput :: userinput(int usergenre, bool wantanimated, vector<string> useractors, vector<string> userdirectors, int hours, int mins){
    
    int genre (23,false);
    
    bool animated;
    
    vector<string> actors (5);
    
    vector<string> directors (5);
    
    time runtime = time();
    
    vector<bool> whatinputs(5,true);
    
    setGenre(usergenre);
    setAnimated(wantanimated);
    setActors(useractors);
    setDirectors(userdirectors);
    setRuntime(hours,mins);
}

userinput :: userinput(int usergenre, bool wantanimated, vector<string> useractors, vector<string> userdirectors){
    int genre (23,false);
    
    bool animated;
    
    vector<string> actors (5);
    
    vector<string> directors (5);
    
    time runtime = runtime();
    
    vector<bool> whatinputs(5);
    whatinputs = {1,1,1,1,0};
    
    setGenre(usergenre);
    setAnimated(wantanimated);
    setActors(useractors);
    setDirectors(userdirectors);
}

userinput :: userinput(int usergenre, bool wantanimated, vector<string> useractors, int hours, int mins){
    int genre (23,false);
    
    bool animated;
    
    vector<string> actors (5);
    
    vector<string> directors (5);
    
    time runtime = runtime();
    
    vector<bool> whatinputs(5);
    whatinputs = {1,1,1,0,1};
    
    setGenre(usergenre);
    setAnimated(wantanimated);
    setActors(useractors);
    setRuntime(hours,mins);
}

userinput :: userinput(int usergenre, bool wantanimated, vector<string> userdirectors, int hours, int mins){
    int genre (23,false);
    
    bool animated;
    
    vector<string> actors (5);
    
    vector<string> directors (5);
    
    time runtime = runtime();
    
    vector<bool> whatinputs(5);
    whatinputs = {1,1,0,1,1};
    
    setGenre(usergenre);
    setAnimated(wantanimated);
    setDirectors(userdirectors);
    setRuntime(hours,mins);
}

userinput :: userinput(int usergenre, bool wantanimated, vector<string> useractors){
    int genre (23,false);
    
    bool animated;
    
    vector<string> actors (5);
    
    vector<string> directors (5);
    
    time runtime = runtime();
    
    vector<bool> whatinputs(5);
    whatinputs = {1,1,1,0,0};
    
    setGenre(usergenre);
    setAnimated(wantanimated);
    setActors(useractors);
}



userinput :: userinput(int usergenre, bool wantanimated, int hours, int mins){
    
    int genre (23,false);
    
    bool animated;
    
    vector<string> actors (5);
    
    vector<string> directors (5);
    
    time runtime = runtime();
    
    vector<bool> whatinputs(5);
    whatinputs = {1,1,0,0,1};
    
    setGenre(usergenre);
    setAnimated(wantanimated);
    setRuntime(hours,mins);
}

userinput :: userinput(int usergenre, vector<string> userdirectors){
    
    int genre (23,false);
    
    bool animated;
    
    vector<string> actors (5);
    
    vector<string> directors (5);
    
    time runtime = runtime();
    
    vector<bool> whatinputs(5);
    
    whatinputs = {1,1,0,1,0}
    
    setGenre(usergenre);
    setAnimated(wantanimated);
    setDirectors(userdirectors);
}



userinput :: vector<bool> getGenre(){
    return genre;
}

userinput :: bool getAnimated(){
    return animated;
}

userinput :: vector<string> getActors(){
    return actors;
}

userinput :: vector<string> getDirectors(){
    return directors;
}

userinput :: int getRuntime(){
    return runtime;
}
