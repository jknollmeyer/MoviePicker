#include <iostream>
#include <cstdio>
#include <fstream>
#include <string>
#include <vector>
#include <array>

using namespace std;

struct settings{ //set in setting window the returned movie(s) MUST obey these criteria
    string max_rating;
    int earliest_release;
    bool exclude_watchedlist;
    bool on_netflix;
} settings;


void initialfileopen(){
    
    /* we will always want these iMDb files open commented out not necessary to open
     if we get no user input pertaining to them */
    
    ofstream genre;
    genre.open("genres.list");
    
    //    ofstream actors;
    //    actors.open("actors.list");
    
    //    ofstream runtime;
    //    runtime.open("running-times.list");
    
    ofstream mpaa;
    mpaa.open("mpaa-ratings-reasons.list");
    
    //    ofstream directors;
    //    directors.open("directors.list");
    
    ofstream released;
    released.open("release-dates.list");
}


class time{     // a time class so user can just put in that they would like to watch a 2hr 30min movie at max
                // these inputs should be typed into a hrs and mins textbox and cast as type int
    int hrs;
    int minutes;
    int totalmins = 60*hrs + mins;
    
public:
    
    runtime(){
        int hrs = 24;
        int minutes = 0;
        int totalmins = 60*hrs + mins;
    }
    
    void sethrs(int hours){
        hrs = hours;
    }
    
    void setmins(int mins){
        minutes = mins;
    }
    
    int getTotalmins(){
        return totalmins;
    }
};
              
