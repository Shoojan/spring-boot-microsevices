<b>SPRING BOOT MICROSERVICES</b>

<ul>Objectives:
	<li>1. Create 3 spring boot projects</li>
		<ul>a. Build a movie catalog service</ul>
		<ul>b. Build a movie info service API</ul>
		<ul>c. Build a ratings data service API</ul>
	<li>2. Have movie-catalog-service call the other two services (the naive way)</li>
	<li>3. Implement a better way (Service Discovery)</li>
</ul>


<p>
	<b>Tasks:</b>
	<li>1. Add an API to movie-catalog-service at /catalog/{userId} that returns a hard-coded list of movie and rating information. (Movie Catalog Service)</li>
	<li>2. Add an API to movie-info-service at /movies/{movieId} that returns a hard-coded list of movie information. (Movie Info Service)</li>
	<li>3. Configure the three microservices to run on a different port each - 8081, 8082 and 8083</li>
</p>


<p>
	<b>How to make a REST call from your code?</b>
	<li>-> Calling REST APIs programatically.</li>
	<li>-> Using a REST client library</li>
	<li>-> Springboot comes with a client already in your classpath - RestTemplate</li>
</p>