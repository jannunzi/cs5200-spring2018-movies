const {render} = ReactDOM
//import React from 'react'
//import { render } from 'react-dom'
//import {hello} from './hello'

render(
  <div>
	<h1>React OMDb API Web Service Client</h1>
	<hello/>
	<h2>Results</h2>
	<table>
		<thead>
			<tr>
				<th>Title</th>
				<th>IMDb ID</th>
			</tr>
		</thead>
		<tbody id="resultsTbl">
		</tbody>
	</table>
  </div>
	, document.getElementById('SimpleReactOmdbClientApp')
)