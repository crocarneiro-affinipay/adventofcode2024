//> using scala 3.5.2
//> using toolkit latest

@main
def solution(): Unit = {
  val path: os.Path = os.root / "Users" / "carloscarneiro" / "github" / "adventofcode2024" / "01" / "input.txt"
  val lines: Seq[String] = os.read.lines(path)

  // n -> number of lines in the input file
  // k -> length of each line in the input file

  // O(n)
  val left: scala.collection.mutable.Buffer[Long] = scala.collection.mutable.Buffer[Long]()
  val right: scala.collection.mutable.Buffer[Long] = scala.collection.mutable.Buffer()
  var n: Int = 0;
  lines.foreach { line =>
    val delimiter = "   ";
    // O(k)
    val si = line.indexOf(delimiter)
    val a = line.substring(0, si).toLong
    val b = line.substring(si + delimiter.length).toLong

    a +=: left
    b +=: right
    n += 1
  }

  val sortedLeft = left.sorted
  val sortedRight = right.sorted

  var result: Long = 0;
  scala.collection.immutable.Range(0, n).foreach { i =>
    result += (sortedLeft(i) - sortedRight(i)).abs
  }

  println("Result => " + result)
}

