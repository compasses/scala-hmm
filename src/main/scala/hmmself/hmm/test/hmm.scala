package hmmself.hmm.test

import breeze.linalg.{*, DenseMatrix, DenseVector}

/**
  * Created by i311352 on 03/05/2017.
  */
object hmm extends App{
//
//  val x = DenseVector[Double](5)
//
//  println(x)
//  import breeze.linalg._
//  import breeze.plot._
//
//  val f = Figure()
//  val p = f.subplot(0)
//  val x = linspace(0.0,1.0)
//  p += plot(x, x :^ 2.0)
//  p += plot(x, x :^ 3.0, '.')
//  p.xlabel = "x axis"
//  p.ylabel = "y axis"
//  f.saveas("lines.png")

  val A = DenseMatrix((0.7, 0.3), (0.4, 0.6))
  val State = DenseVector(("H",0), ("C",1))
  val Observs = DenseVector(("S",0), ("M",1), ("L",2))

  val B = DenseMatrix((0.1, 0.4, 0.5), (0.7, 0.2, 0.1))
  val Pai = DenseVector(0.6, 0.4)

  var State4 = DenseMatrix.zeros[Tuple2[String, Int]](16, 4)

  var index = 0
  for (i1 <-0 to 1) {
    for (i2 <-0 to 1) {
      for (i3 <-0 to 1) {
        for (i4 <-0 to 1) {
          State4(index, ::) := DenseVector(State(i1), State(i2), State(i3), State(i4)).t
          index += 1
        }
      }
    }
  }
  println("4 state matrix is \r\n" + State4.toString())
  println( "total " +  Pai.foldLeft(0.0)((p1:Double, p2:Double) => p1+p2 ))

  for (row <- 0 to 15) {
    val rr = State4(row, ::).t
   // var Ss:String = ""
    val S = rr.foldLeft("")((str: String, t: Tuple2[String, Int]) => str + t._1)

    println( "row " + row + rr)

  }



}
