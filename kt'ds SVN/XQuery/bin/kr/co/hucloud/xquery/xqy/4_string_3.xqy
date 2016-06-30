let $fruits :=
	<fruits>
	   <fruit>Apple</fruit>
	   <fruit>Orange</fruit>
	   <fruit>Guava</fruit>
	   <fruit>Pinapple</fruit>
	</fruits>

return
	<results>
	   <fruits>
			{string-join($fruits/fruit, ',')}
	   </fruits>
	</results>
   
(: 
	아이템 끼리의 글자를 더한다
:)