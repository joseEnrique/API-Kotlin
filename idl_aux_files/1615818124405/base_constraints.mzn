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

constraint ((((p2Set==1)) -> ((p4Set==1)))
/\
(((p1Set==1)) -> (((p3Set==1 /\ p3==true) \/ ((not (p3Set==1)))) /\ (not (p7Set==1)) /\ (p9Set==1 /\ (p9==0))))
/\
((((p1Set==1)) \/ ((p3Set==1)) \/ ((p5Set==1) /\ (p7Set==1)) \/ ((p9Set==1) /\ (p1Set==1))))
/\
((not (((p1Set==1 /\ p1==true)) \/ ((p2Set==1 /\ p2==true)) \/ ((p3Set==1 /\ p3==false)))))
/\
((not ((((p7Set==1) /\ (p9Set==1)) -> (((p8Set==1 /\ (p8==1))) /\ ((p5Set==1) /\ (p10Set==1 /\ (p10==2))))) /\ ((not ((p7Set==1) /\ (p9Set==1))) -> ((not ((p8Set==1 /\ (p8==1)))) /\ (not ((p5Set==1) /\ (p10Set==1 /\ (p10==2)))))) /\ (((p8Set==1 /\ (p8==1))) -> (((p7Set==1) /\ (p9Set==1)) /\ ((p5Set==1) /\ (p10Set==1 /\ (p10==2))))) /\ ((not ((p8Set==1 /\ (p8==1)))) -> ((not ((p7Set==1) /\ (p9Set==1))) /\ (not ((p5Set==1) /\ (p10Set==1 /\ (p10==2)))))) /\ (((p5Set==1) /\ (p10Set==1 /\ (p10==2))) -> (((p7Set==1) /\ (p9Set==1)) /\ ((p8Set==1 /\ (p8==1))))) /\ ((not ((p5Set==1) /\ (p10Set==1 /\ (p10==2)))) -> ((not ((p7Set==1) /\ (p9Set==1))) /\ (not ((p8Set==1 /\ (p8==1)))))))))
/\
(((((p1Set==1)) -> (((p5Set==1)))) /\ ((not ((p1Set==1))) -> ((not ((p5Set==1))))) /\ (((p5Set==1)) -> (((p1Set==1)))) /\ ((not ((p5Set==1))) -> ((not ((p1Set==1)))))))
/\
((not ((((p1Set==1)) -> ((not ((p5Set==1))) /\ (not ((p7Set==1))) /\ (not ((p2Set==1 /\ p2==false))) /\ (not ((p6Set==1 /\ (p6==2)))))) /\ (((p5Set==1)) -> ((not ((p1Set==1))) /\ (not ((p7Set==1))) /\ (not ((p2Set==1 /\ p2==false))) /\ (not ((p6Set==1 /\ (p6==2)))))) /\ (((p7Set==1)) -> ((not ((p1Set==1))) /\ (not ((p5Set==1))) /\ (not ((p2Set==1 /\ p2==false))) /\ (not ((p6Set==1 /\ (p6==2)))))) /\ (((p2Set==1 /\ p2==false)) -> ((not ((p1Set==1))) /\ (not ((p5Set==1))) /\ (not ((p7Set==1))) /\ (not ((p6Set==1 /\ (p6==2)))))) /\ (((p6Set==1 /\ (p6==2))) -> ((not ((p1Set==1))) /\ (not ((p5Set==1))) /\ (not ((p7Set==1))) /\ (not ((p2Set==1 /\ p2==false))))))))
/\
(((((p1Set==1)) -> ((not ((p3Set==1))))) /\ (((p3Set==1)) -> ((not ((p1Set==1)))))))
/\
(((((p6Set==1 /\ p8Set==1 /\ p6!=p8)) -> (((p8Set==1 /\ p10Set==1 /\ p8==p10)))) /\ ((not ((p6Set==1 /\ p8Set==1 /\ p6!=p8))) -> ((not ((p8Set==1 /\ p10Set==1 /\ p8==p10))))) /\ (((p8Set==1 /\ p10Set==1 /\ p8==p10)) -> (((p6Set==1 /\ p8Set==1 /\ p6!=p8)))) /\ ((not ((p8Set==1 /\ p10Set==1 /\ p8==p10))) -> ((not ((p6Set==1 /\ p8Set==1 /\ p6!=p8)))))))
/\
((((((((p5Set==1 /\ p5==false)) -> ((not ((p4Set==1 /\ p4==true))))) /\ (((p4Set==1 /\ p4==true)) -> ((not ((p5Set==1 /\ p5==false))))) /\ (((p5Set==1 /\ p5==false)) \/ ((p4Set==1 /\ p4==true))))) -> ((not (((((p4Set==1)) -> ((not ((p4Set==1 /\ p4==true))))) /\ (((p4Set==1 /\ p4==true)) -> ((not ((p4Set==1))))) /\ (((p4Set==1)) \/ ((p4Set==1 /\ p4==true)))))) /\ (not (((((p4Set==1 /\ p4==true)) -> ((not ((p6Set==1))))) /\ (((p6Set==1)) -> ((not ((p4Set==1 /\ p4==true))))) /\ (((p4Set==1 /\ p4==true)) \/ ((p6Set==1)))))))) /\ ((((((p4Set==1)) -> ((not ((p4Set==1 /\ p4==true))))) /\ (((p4Set==1 /\ p4==true)) -> ((not ((p4Set==1))))) /\ (((p4Set==1)) \/ ((p4Set==1 /\ p4==true))))) -> ((not (((((p5Set==1 /\ p5==false)) -> ((not ((p4Set==1 /\ p4==true))))) /\ (((p4Set==1 /\ p4==true)) -> ((not ((p5Set==1 /\ p5==false))))) /\ (((p5Set==1 /\ p5==false)) \/ ((p4Set==1 /\ p4==true)))))) /\ (not (((((p4Set==1 /\ p4==true)) -> ((not ((p6Set==1))))) /\ (((p6Set==1)) -> ((not ((p4Set==1 /\ p4==true))))) /\ (((p4Set==1 /\ p4==true)) \/ ((p6Set==1)))))))) /\ ((((((p4Set==1 /\ p4==true)) -> ((not ((p6Set==1))))) /\ (((p6Set==1)) -> ((not ((p4Set==1 /\ p4==true))))) /\ (((p4Set==1 /\ p4==true)) \/ ((p6Set==1))))) -> ((not (((((p5Set==1 /\ p5==false)) -> ((not ((p4Set==1 /\ p4==true))))) /\ (((p4Set==1 /\ p4==true)) -> ((not ((p5Set==1 /\ p5==false))))) /\ (((p5Set==1 /\ p5==false)) \/ ((p4Set==1 /\ p4==true)))))) /\ (not (((((p4Set==1)) -> ((not ((p4Set==1 /\ p4==true))))) /\ (((p4Set==1 /\ p4==true)) -> ((not ((p4Set==1))))) /\ (((p4Set==1)) \/ ((p4Set==1 /\ p4==true)))))))))));

constraint p2Set = 1;
constraint p4Set = 1;
constraint p6Set = 1;
constraint p8Set = 1;
constraint p10Set = 1;
constraint p1 = 0;
constraint p1Set = 1;
constraint p2 = 0;
constraint p2Set = 1;
constraint p3Set = 0;
constraint p4 = 1;
constraint p4Set = 1;
constraint p5 = 1;
constraint p5Set = 1;
constraint p6 = 3;
constraint p6Set = 1;
constraint p7Set = 0;
constraint p8 = 1;
constraint p8Set = 1;
constraint p9 = 0;
constraint p9Set = 1;
constraint p10 = 4;
constraint p10Set = 1;
solve satisfy;
