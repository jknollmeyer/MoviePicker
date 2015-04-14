#include <iostream>
#include <cstdio>
#include <fstream>
#include <string>
#include <vector>
#include <array>
#include <stdio>

using namespace std;

struct settings{ //set in setting window the returned movie(s) MUST obey these criteria
    vector <bool> max_rating (6); /*true maxrating and up ratings  {G,PG,PG-13,R,NR,NC-17} */
    int earliest_release;
//    bool exclude_watchedlist; /* we'd have to include a watched list funtionality */
//    bool on_netflix;  /* we'd have to include an on netflix funtionality */
} settingspane;

struct movie{
    string title;
    int year;
    string genre;
} tonights_movie;


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
}


class time{     // a time class so user can just put in that they would like to watch a 2hr 30min movie at max
                // these inputs should be typed into a hrs and mins textbox and cast as type int
    int hrs;
    int minutes;
    int totalmins = 60*hrs + mins;
    
public:
    
    time(){
        int hrs = 24;
        int minutes = 0;
        int totalmins = 60*hrs + mins;
    }
    time(int hours, int mins){
        int hrs = hours;
        int minutes = mins;
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
              
