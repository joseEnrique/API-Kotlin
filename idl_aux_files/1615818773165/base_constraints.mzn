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
set of int: data_p6;
var data_p6: p6;
set of int: data_p6Set;
var data_p6Set: p6Set;
set of int: data_p7;
var data_p7: p7;
set of int: data_p7Set;
var data_p7Set: p7Set;
set of int: data_p8;
var data_p8: p8;
set of int: data_p8Set;
var data_p8Set: p8Set;
set of int: data_p9;
var data_p9: p9;
set of int: data_p9Set;
var data_p9Set: p9Set;
set of int: data_p10;
var data_p10: p10;
set of int: data_p10Set;
var data_p10Set: p10Set;

constraint ((((not (p1Set==1 /\ p1==false))) -> ((p2Set==1 /\ (p2==0)) /\ (p3Set==1 /\ p3==5)))
/\
((((p4Set==1 /\ (p4==1 \/ p4==2))) \/ ((p5Set==1 /\ p5<(-200))) \/ ((p6Set==1 /\ p6==true))))
/\
(((((p7Set==1 /\ (p7==3))) -> ((not ((p8Set==1 /\ p8>=10))))) /\ (((p8Set==1 /\ p8>=10)) -> ((not ((p7Set==1 /\ (p7==3))))))))
/\
(((p3Set==1 /\ p5Set==1 /\ p8Set==1) -> (p3*p5*p8<5)))
/\
((((p1Set==1 /\ p6Set==1 /\ p1==p6)) \/ ((p4Set==1 /\ p7Set==1 /\ p4==p7)))));

constraint p1Set = 1;
constraint p2Set = 1;
constraint p3Set = 1;
constraint p4Set = 1;
constraint p5Set = 1;
constraint p6Set = 1;
constraint p7Set = 1;
constraint p8Set = 1;
constraint p9Set = 1;
constraint p10Set = 1;
constraint p1 = 1;
constraint p1Set = 1;
constraint p2 = 0;
constraint p2Set = 1;
constraint p3 = 5;
constraint p3Set = 1;
constraint p4 = 8;
constraint p4Set = 1;
constraint p5 = -300;
constraint p5Set = 1;
constraint p6 = 0;
constraint p6Set = 1;
constraint p7 = 8;
constraint p7Set = 1;
constraint p8 = 1;
constraint p8Set = 1;
constraint p9 = 4;
constraint p9Set = 1;
constraint p10 = 5;
constraint p10Set = 1;
solve satisfy;
