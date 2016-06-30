let $items := 	(
					'orange', 
					<apple/>, 
					<fruit type="juicy"/>, 
					<vehicle type="car">sentro</vehicle>, 
					1, 2, 3, 'a', 'b', "abc"
				)
let $count := count($items)
return
<result>
   <count>{$count}</count>
   
   <items>
      {
	     for $item in $items
         return <item>{$item}</item>
      }
   </items>
   
</result>

(:
	배열을 사용해 xml 문서를 만들어 낼 수 있다.
	배열은 ( ) 를 사용해 만든다. ,(Comma)로 아이템들을 구분한다.
	
	count($배열변수명) 을 사용하면 배열 속 아이템의 개수를 구해올 수 있다.
:)