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

constraint ((((((p7Set==1) /\ (p8Set==1)) -> ((not ((p7Set==1) /\ (p8Set==1) \/ (p9Set==1 /\ (p9==0)))))) /\ (((p7Set==1) /\ (p8Set==1) \/ (p9Set==1 /\ (p9==0))) -> ((not ((p7Set==1) /\ (p8Set==1)))))))
/\
(((((p4Set==1) /\ (p5Set==1)) -> (((p6Set==1) /\ (p7Set==1)))) /\ ((not ((p4Set==1) /\ (p5Set==1))) -> ((not ((p6Set==1) /\ (p7Set==1))))) /\ (((p6Set==1) /\ (p7Set==1)) -> (((p4Set==1) /\ (p5Set==1)))) /\ ((not ((p6Set==1) /\ (p7Set==1))) -> ((not ((p4Set==1) /\ (p5Set==1)))))))
/\
((not ((((p5Set==1 /\ p5==1000)) -> ((not ((p4Set==1 /\ p4==10000) \/ (p3Set==1 /\ p3==100000))) /\ (not ((p2Set==1 /\ p2==1000000))))) /\ (((p4Set==1 /\ p4==10000) \/ (p3Set==1 /\ p3==100000)) -> ((not ((p5Set==1 /\ p5==1000))) /\ (not ((p2Set==1 /\ p2==1000000))))) /\ (((p2Set==1 /\ p2==1000000)) -> ((not ((p5Set==1 /\ p5==1000))) /\ (not ((p4Set==1 /\ p4==10000) \/ (p3Set==1 /\ p3==100000))))))))
/\
(((p1Set==1) /\ (((p2Set==1)) \/ ((p3Set==1)))) -> (((p1Set==1 /\ p2Set==1 /\ p4Set==1 /\ p1+p2+p4<=999)) /\ ((((p6Set==1)) -> ((not (((((p7Set==1)) -> (((p8Set==1)))) /\ ((not ((p7Set==1))) -> ((not ((p8Set==1))))) /\ (((p8Set==1)) -> (((p7Set==1)))) /\ ((not ((p8Set==1))) -> ((not ((p7Set==1)))))))))) /\ ((((((p7Set==1)) -> (((p8Set==1)))) /\ ((not ((p7Set==1))) -> ((not ((p8Set==1))))) /\ (((p8Set==1)) -> (((p7Set==1)))) /\ ((not ((p8Set==1))) -> ((not ((p7Set==1))))))) -> ((not ((p6Set==1))))) /\ (((p6Set==1)) \/ (((((p7Set==1)) -> (((p8Set==1)))) /\ ((not ((p7Set==1))) -> ((not ((p8Set==1))))) /\ (((p8Set==1)) -> (((p7Set==1)))) /\ ((not ((p8Set==1))) -> ((not ((p7Set==1)))))))))))
/\
(((not ((p4Set==1 /\ p5Set==1 /\ p4==p5) /\ ((((p6Set==1)) -> ((not ((p7Set==1))))) /\ (((p7Set==1)) -> ((not ((p6Set==1))))))))) -> ((((p6Set==1 /\ (p6==1))) \/ ((p7Set==1) /\ (p8Set==1 /\ (p8==2)))) \/ ((((p1Set==1)) -> ((not ((p3Set==1))))) /\ (((p3Set==1)) -> ((not ((p1Set==1))))) /\ (((p1Set==1)) \/ ((p3Set==1)))))));

constraint p1Set = 0;
constraint p2Set = 0;
constraint p3Set = 0;
constraint p4Set = 0;
constraint p5Set = 0;
constraint p6Set = 0;
constraint p7Set = 0;
constraint p8Set = 0;
constraint p9Set = 0;
constraint p10Set = 0;
solve satisfy;
