let $books := doc("src/kr/co/hucloud/xquery/xml/books.xml")
return <results>
{
   for $x in $books/books/book
   where $x/price > 30
   order by $x/price ascending
   return $x/title
}
</results>
(: 
	return <결과를 둘러쌀 값>
	{
		for $x in $books/books/book
		where $x/price>30
		order by $x/price ascending <-- order by 는 price 값으로 오름차순 정렬한다
							  			ascending 과 descending이 있다.
						           		정렬 방식을 생략 할 경우 기본으로 ascending 이 적용된다.
						           		다 차수 정렬을 하려면 ,(Comma)로 조건을 이어 나가면 된다.
		return $x/title
	}
	<결과를 둘러 쌀 값>
:)