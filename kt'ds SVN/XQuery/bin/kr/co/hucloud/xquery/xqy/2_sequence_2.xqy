let $items := (1,2,3,4,5,6)
let $count := count($items)
return
   <result>
      <count>{$count}</count>
      
      <items>
      {
         for $item in $items[2]
         return <item>{$item}</item>
      }
      </items>
      
   </result>

(:
	배열 변수는 인덱스를 사용해 값을 가져올 수 있다.
	배열 인덱스의 접근은 [] (대괄호)를 사용해 할 수 있다.
:)