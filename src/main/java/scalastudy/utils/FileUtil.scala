package scalastudy.utils

import scala.io.Source
import scalastudy.traits.LineHandler

/**
 * Created by lovesqcc on 16-3-27.
 */
trait FileUtil extends LineHandler {

  def readFile(filename:String): String = {
    val fileSource =  Source.fromFile(filename)
    try {
      return fileSource.mkString
    } finally {
      fileSource.close()
    }
  }

  def readFileLines(filename:String):List[String] = {
    val fileSource =  Source.fromFile(filename)
    try {
      return fileSource.getLines().toList
    } finally {
      fileSource.close()
    }
  }

  def handleFile(filename:String):List[Any] = {
    return readFileLines(filename).map(handle(_)).toList
  }

  def handleFileWithNoReturn(filename:String, lineHandler: LineHandler):Unit = {
    readFileLines(filename).foreach { line =>
      lineHandler.handle(line)
    }
  }

}