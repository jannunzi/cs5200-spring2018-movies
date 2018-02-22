<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="/">
		<H1>Movies</H1>
		<TABLE>
			<THEAD>
				<TR>
					<TH>IMDBId</TH>
					<TH>Title</TH>
					<TH>Plot</TH>
					<TH>Poster</TH>
				</TR>
			</THEAD>
			<TBODY>
				<xsl:apply-templates/>
			</TBODY>
		</TABLE>
	</xsl:template>
	<xsl:template match="movies/movie">
		<TR>
			<xsl:attribute name="id">
				<xsl:value-of select="@imdbId"/>
			</xsl:attribute>
			<TD><xsl:value-of select="@imdbId"/></TD>
			<TD><xsl:value-of select="title"/></TD>
			<TD><xsl:value-of select="plot"/></TD>
			<TD>
				<img>
					<xsl:attribute name="src">
						<xsl:value-of select="poster"/>
					</xsl:attribute>
				</img>
			</TD>
		</TR>
	</xsl:template>
</xsl:stylesheet>