
<h1> Entity Problem Face </h1>
<p> Entity name must be same while fetch data from a table such as </P>
<p>
@Entity(name ="products")
class Product{
.. ..
.. ..
}

here  while fetch data from a table query must be like 
</P>
<p> FROM products </P> 

<P> Here products is entity name</p>

<p>in one to one join, foreign key's column name must be different otherwise duplicaion key exception happened in hibernate</P>


