package org.pickme.i18n

class MessageController {
	def Boolean scaffold = true

    def index = {
      response.contentType = "application/csv"
      response.setHeader("Pragma", "");
      response.setHeader("Cache-Control", "must-revalidate");
      response.setHeader("Content-disposition", "attachment; filename=mytest.csv")

      def httpout = response.outputStream
	  httpout << readInput()
      return null
    }


  def static String readInput() {
    StringBuffer buffer = new StringBuffer()
    try {
      FileInputStream fis = new FileInputStream("invoices.csv")
      InputStreamReader isr = new InputStreamReader(fis, "UTF8")
      Reader in1 = new BufferedReader(isr)
      int ch
      while ((ch = in1.read()) > -1) {
        buffer.append((char) ch)
      }
      in1.close()
      return buffer.toString()
    } catch (IOException e) {
      e.printStackTrace()
      return null
    }
  }

}