<result>
{
   if(not(doc("src/kr/co/hucloud/xquery/xml/books.xml"))) then (
      <error>
         <message>books.xml does not exist</message>
      </error>
   )
   else ( 
      for $x in doc("src/kr/co/hucloud/xquery/xml/books.xml")/books/book	
      where $x/price>30
      return $x/title
   )
}
</result>