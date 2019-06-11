import scala.io.Source

val start: String = "<products>"
val startitem: String = "<product>"
val end: String = "</products>"
val enditem: String = "</product>"

val filename = "/home/marcela/Downloads/EBAY/xaa.xml"

val pattern = """<code>(eg|ega|egb|egc|egd|ege|eh|eha|ehb|ehc|ehd|ehe|ehf|ehg|ebcb|ebeb|ebub|jbe|jea|jfc|jib|jja|joa|joaa|joab|joac|joad|joae|jgh|egf|ehh|jpd|jzhb|jlbd|eum|elab|elbb|elcb|ejga|3me|jkaad|cpx|ehi|euma|eumb|eumc|eumd|eume|epk|epka|epkb|epkc|ehj|jkbb|jzj|ehk|ehl|egh|eumf|jlga|rdx|rdxa|rdxb|rdxc|)<\/code>""".r
var category = shoe.shoe_category

val match1 = pattern.findFirstIn(category)
match1 match {
  case Some(s) => {
    Some(shoe)
  }
  case None => {
    None
  }
}


var x = 0;
for(line<-Source.fromFile(filename).getLines) {
  if(line contains start)  {
      println("Beginning of file detected Line "+x.toString)
      println(line)
  }
  if(line contains startitem)  {
    println("Beginning of item detected Line "+x.toString)
    println(line)
  }
  if(line contains enditem)  {
    println("Ending of item detected Line "+x.toString)
    println(line)
  }
  if(line contains end)  {
    println("end of file detected Line "+x.toString)
    println(line)
  }
  //  println(x)
  x= x+1
}
println("Total lines "+x.toString)
