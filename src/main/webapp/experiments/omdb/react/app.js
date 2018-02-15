const {render} = ReactDOM
render(
  <div>
	<h1>Angular OMDb API Web Service Client</h1>
	<h2>Search</h2>
	<label for="keywordFld">Search Keyword</label>
	<input id="keywordFld"/>
	<button>Search</button>
  </div>
	, document.getElementById('SimpleReactOmdbClientApp')
)