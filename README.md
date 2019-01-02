# RestAssuredNetflix

#####1. Choose any IDE (I prefer IntelliJ)

#####2. Have JDK setup pre-requisite

#####3. Create Maven Project

#####4. Add Dependencies to POM file (Check versions in POM file for below dependencies)

#####4.1) testng 6.10
#####4.2) rest_assured 2.9.0
#####4.3) json-schema-validator 2.9.0
#####4.4) json-path 2.2.0

####Getting started with your own custom URI(Unifrom Resource Identifier)

##### Install NPM (node.js)

Installer - https://nodejs.org/en/download/package-manager/
Error in path setup solution (for win) - https://stackoverflow.com/questions/27344045/installing-node-js-and-npm-on-windows-10

##### Install JSON Server

```npm install -g json-server```

##### Create a db.json file with some data

```{
  "posts": [
    { "id": 1, "title": "json-server", "author": "typicode" }
  ],
  "comments": [
    { "id": 1, "body": "some comment", "postId": 1 }
  ],
  "profile": { "name": "typicode" }
}
```

##### Start JSON Server
```json-server --watch  db.json (path to db.json file)```

Now if you go to http://localhost:3000/posts/1, you'll get

```{ "id": 1, "title": "json-server", "author": "typicode" }```

###### Also when doing requests, it's good to know that:
If you make POST, PUT, PATCH or DELETE requests, changes will be automatically and safely saved to db.json using lowdb.
Your request body JSON should be object enclosed, just like the GET output. (for example {"name": "Foobar"})
Id values are not mutable. Any id value in the body of your PUT or PATCH request will be ignored. Only a value set in a POST request will be respected, but only if not already taken.
A POST, PUT or PATCH request should include a Content-Type: application/json header to use the JSON in the request body. Otherwise it will result in a 200 OK but without changes being made to the data.

####Routes

Based on the previous db.json file, here are all the default routes. You can also add other routes using --routes.

##### Plural routes

```
GET    /posts
GET    /posts/1
POST   /posts
PUT    /posts/1
PATCH  /posts/1
DELETE /posts/1
```
#### Singular routes
```
GET    /profile
POST   /profile
PUT    /profile
PATCH  /profile
```

####Filter

```Use . to access deep properties```

GET /posts?title=json-server&author=typicode
GET /posts?id=1&id=2
GET /comments?author.name=typicode


#### Paginate

Use _page and optionally _limit to paginate returned data.

In the Link header you'll get first, prev, next and last links.

```
GET /posts?_page=7
GET /posts?_page=7&_limit=20
10 items are returned by default
```

#### Sort

Add _sort and _order (ascending order by default)

```
GET /posts?_sort=views&_order=asc
GET /posts/1/comments?_sort=votes&_order=asc
For multiple fields, use the following format:
GET /posts?_sort=user,views&_order=desc,asc
```

#### Slice

Add _start and _end or _limit (an X-Total-Count header is included in the response)

```
GET /posts?_start=20&_end=30
GET /posts/1/comments?_start=20&_end=30
GET /posts/1/comments?_start=20&_limit=10
```
Works exactly as Array.slice (i.e. _start is inclusive and _end exclusive)

#### Operators

Add _gte or _lte for getting a range

```
GET /posts?views_gte=10&views_lte=20
Add _ne to exclude a value
GET /posts?id_ne=1
Add _like to filter (RegExp supported)
GET /posts?title_like=server
```
#### Full-text search

Add q

```
GET /posts?q=internet
```

#### Relationships

To include children resources, add _embed

```
GET /posts?_embed=comments
GET /posts/1?_embed=comments
```
To include parent resource, add _expand

```
GET /comments?_expand=post
GET /comments/1?_expand=post
```
To get or create nested resources (by default one level, add custom routes for more)

```
GET  /posts/1/comments
POST /posts/1/comments
```

#### Database
```
GET /db
```

#### Homepage

Returns default index file or serves ./public directory

```
GET /
```
