
val week=1

val day_start=(week-1)*7+1
print(day_start)

var day_stop=day_start+7

if(day_stop>31) {
  day_stop=32
}


val daysn=Seq.range(day_start, day_stop)

println(daysn)



val days = daysn.map(d => "%02d".format(d))

println(days)
