set of int: data_p1;
var data_p1: p1;
set of int: data_p1Set;
var data_p1Set: p1Set;
set of int: data_p2;
var data_p2: p2;
set of int: data_p2Set;
var data_p2Set: p2Set;
set of int: data_p3;
var data_p3: p3;
set of int: data_p3Set;
var data_p3Set: p3Set;
set of int: data_p4;
var data_p4: p4;
set of int: data_p4Set;
var data_p4Set: p4Set;
set of int: data_p5;
var data_p5: p5;
set of int: data_p5Set;
var data_p5Set: p5Set;

constraint ((((((p1Set==1)) -> ((not ((p2Set==1))))) /\ (((p2Set==1)) -> ((not ((p1Set==1))))))));

constraint p1Set = 0;
constraint p2Set = 0;
constraint p3Set = 0;
constraint p4Set = 0;
constraint p5Set = 0;
solve satisfy;
