package com.example

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkContext, SparkConf}
import io.circe.parser._
import io.circe.generic.auto._


object JsonReader {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("Usage: JsonReader <filename>")
      sys.exit(-1)
    }
    val conf: SparkConf = new SparkConf().setAppName("json_reader_Kruglov")
    val sc: SparkContext = new SparkContext(conf)
    try {
      val file: RDD[String] = sc.textFile(args(0))
      file.map(s => decode[WineProfile](s) match {
          case Right(value) => value
          case Left(ex) => println(s"Invalid JSON :( ${ex.getLocalizedMessage}")
        })
        .foreach{println}

    } catch {
      case e: Throwable =>
        println(s"Error: ${e.getLocalizedMessage}")
        sys.exit(-1)
    } finally {
      sc.stop()
    }

  }

}
