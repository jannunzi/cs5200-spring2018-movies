<?xml-stylesheet version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="/movies">
		<H1>Movies Grouped By Year Released</H1>
		<xsl:for-each-group
			select="movie"
			group-by="released">
			
			<H2>
  Movies Released on <xsl:value-of select="released"></xsl:value-of>
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