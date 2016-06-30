let $items := (1,2,4,4,5,5)
let $unique-items := distinct-values($items)
return
   <result>   
   
      <items>
      {
         for $item in $unique-items
         return <item>{$item}</item>
      }
      </items>
   
   </result>
