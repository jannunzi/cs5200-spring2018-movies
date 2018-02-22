import {Component} from 'react'

export class SearchComponent extends Component {
	render() {
		return (
			<h2>Search</h2>
			<label for="keywordFld">Search Keyword</label>
			<input id="keywordFld"/>
			<button>Search</button>
		);
	}
}