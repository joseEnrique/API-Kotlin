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

constraint (((((p1Set==1 /\ (p1==0))) \/ ((p2Set==1 /\ (p2==0)))))
/\
(((((p2Set==1 /\ (p2==1))) -> ((not ((p3Set==1 /\ (p3==1)))))) /\ (((p3Set==1 /\ (p3==1))) -> ((not ((p2Set==1 /\ (p2==1)))))) /\ (((p2Set==1 /\ (p2==1))) \/ ((p3Set==1 /\ (p3==1))))))
/\
(((((p2Set==1 /\ (p2==2))) -> (((p3Set==1 /\ (p3==3))))) /\ ((not ((p2Set==1 /\ (p2==2)))) -> ((not ((p3Set==1 /\ (p3==3)))))) /\ (((p3Set==1 /\ (p3==3))) -> (((p2Set==1 /\ (p2==2))))) /\ ((not ((p3Set==1 /\ (p3==3)))) -> ((not ((p2Set==1 /\ (p2==2))))))))
/\
(((((p4Set==1 /\ (p4==4))) -> ((not ((p5Set==1 /\ (p5==5)))))) /\ (((p5Set==1 /\ (p5==5))) -> ((not ((p4Set==1 /\ (p4==4))))))))
/\
(((p1Set==1 /\ p5Set==1) -> (p1==p5))));

constraint p1Set = 1;
constraint p2Set = 1;
constraint p3Set = 1;
constraint p4Set = 1;
constraint p5Set = 1;
constraint p1 = 0;
constraint p1Set = 1;
constraint p2 = 1;
constraint p2Set = 1;
constraint p3 = 2;
constraint p3Set = 1;
constraint p4 = 3;
constraint p4Set = 1;
constraint p5 = 4;
constraint p5Set = 1;
solve satisfy;
