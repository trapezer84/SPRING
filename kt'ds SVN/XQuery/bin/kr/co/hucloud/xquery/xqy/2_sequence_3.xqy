let $items := (1,2,3,4,5,6)
let $count := count($items)
return
   <result>
      <count>{$count}</count>
      
      <items>
      {
         for $item in $items[.=(1,2,3)]
         return <item>{$item}</item>
      }
      </items>
      
   </result>

(:
	배열에서 인덱스를 이용해 가져올 때, 여러 인덱스를 동시에 가져오게 할 수도 있다.
	대괄호 안에 .=(인덱스, 인덱스, ...) 를 적으면 해당하는 인덱스의 값을 모두 가져온다.
:)