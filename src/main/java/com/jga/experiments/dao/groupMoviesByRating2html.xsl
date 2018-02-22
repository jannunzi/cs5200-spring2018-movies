<?xml-stylesheet version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="/movies">
		<H1>Movies Grouped By Rating</H1>
		<xsl:for-each-group
			select="movie"
			group-by="@rating">
			<H2>
				<xsl:value-of select="@rating"></xsl:value-of> Movies
			</H2>
			<UL>
			<xsl:for-each select="current-group()">
				<LI>
					<xsl:value-of select="title"/>
				</LI>
			</xsl:for-each>
			</UL>
		</xsl:for-each-group>
	</xsl:template>
</xsl:stylesheet>