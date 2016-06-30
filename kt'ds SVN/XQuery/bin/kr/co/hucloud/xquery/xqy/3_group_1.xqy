let $items := (1,2,3,4,5,6)
let $count := count($items)
let $sum := sum($items)
let $avg := avg($items)
let $min := min($items)
let $max := max($items)
return
   <result>
      <count>{$count}</count>     
      <sum>{$sum}</sum>     
      <avg>{$avg}</avg>     
      <min>{$min}</min>     
      <max>{$max}</max>     
   </result>
