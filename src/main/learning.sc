val msg = "Hello, world!"

val msg3: String = "Hello yet again, world!"

def max(x: Int, y: Int): Int = {
  if (x > y) x
  else y
}

val RuleToTest1 = (shoe: Shoe) => {
  val sizeStringPattern = """<name>Numara<\/name>\s?<values>\s?((<string>([^<]+)<\/string>)+)\s?<\/values>""".r
  val internal_material = shoe.internal_material.replaceAll(""">(\s[^<]+)<""", "><")
  val sizeMatches = sizeStringPattern.findFirstMatchIn(internal_material)
  var sizesString = ""
  sizeMatches match {
    case Some(s) => {
      sizesString = s.group(1)
    }
    case None => {
      sizesString = ""
    }
  }
  val sizesPattern = """<string>([^<]+)<\/string>""".r
  var listShoes : List[ShoeSize]= Nil
  for (s <- sizesPattern findAllIn  sizesString) {
    val Decimal = """(\d+)(\.\d*)?""".r
    for (s2 <- Decimal findFirstIn s) {
      val shoeSize = ShoeSize(s2,"eu","","","","","","","","","")
      listShoes=shoeSize::listShoes
    }
  }
  Some(shoe.copy(sizes = listShoes.toSeq))
}


val RuleToTest2 = (shoe: Shoe) => {
  //  case class ShoeSize(size_numeric: String, scale: String, retailed_size_numeric: String, retailed_scale:String)
  val sizeStringPattern = """<name>Numara<\/name>\s?<values>\s?((<string>([^<]+)<\/string>)+)\s?<\/values>""".r
  val internal_material = shoe.internal_material.replaceAll(""">(\s[^<]+)<""", "><")
  val sizeMatches = sizeStringPattern.findFirstMatchIn(internal_material)
  var sizesString = ""
  sizeMatches match {
    case Some(s) => {
      sizesString = s.group(1)
    }
    case None => {
      sizesString = ""
    }
  }
  val sizesPattern = """<string>([^<]+)<\/string>""".r
  var listShoes : List[ShoeSize]= Nil
  var halfstring : String = "";
  for (s <- sizesPattern findAllIn  sizesString) {
    val Decimal = """(\d+)(\.\d*)?""".r
    val halfSizePattern = """(-)""".r
    val halfSizeMatch=halfSizePattern.findFirstMatchIn(s);
    halfSizeMatch match {
      case Some(s) => {
        halfstring = ".5";
      }
      case None => {
        halfstring = ""
      }
    }
    for (s2 <- Decimal findFirstIn s) {
      val shoeSize = ShoeSize(s2+halfstring,"eu","","","","","","","","","")
      listShoes=shoeSize::listShoes
    }
  }
  Some(shoe.copy(sizes = listShoes.toSeq))
}


def max2(x: Int, y: Int) = if (x > y) x else y

val oneTwoThree = List(1, 2, 3)

val oneTwo = List(1, 2)
val threeFour = List(3, 4)

val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo +" and "+ threeFour +" were not mutated.")
println("Thus, "+ oneTwoThreeFour +" is a new list.")


def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List()
  => List(x)
  case y :: ys => if (x <= y) x :: xs
  else y :: insert(x, ys)
}

val twoThree = List(2, 3)
//val oneTwoThree = 1 :: twoThree

var ejemplo : List[Int]= Nil


def append(x: Int, xs: List[Int]): List[Int]=x::xs


ejemplo=append(1,ejemplo)

ejemplo=append(3,ejemplo)

ejemplo=5::ejemplo

println(ejemplo)

println(ejemplo mkString ",")








