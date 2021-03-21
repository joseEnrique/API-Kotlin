set of int: data_p1;
var data_p1: p1;
set of int: data_p1Set;
var data_p1Set: p1Set;


constraint p1 = not boolean;
constraint p1Set = 1;
solve satisfy;
