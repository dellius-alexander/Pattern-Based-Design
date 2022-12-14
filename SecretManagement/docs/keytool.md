<div class="IND large-9 medium-8 columns" dir="ltr">
<a id="BEGIN" name="BEGIN"></a>
<a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549"></a> <span id="PAGE" style="display:none;">20/65</span> <!-- End Header -->
<h1 id="JSWOR-GUID-5990A2E4-78E3-47B7-AE75-6D1826259549" class="sect1">keytool</h1>
<div>
<p><span>You use the <code class="codeph">keytool</code> command and options to manage a keystore (database) of cryptographic keys, X.509 certificate chains, and trusted certificates.</span></p>
<div class="section">
<p class="subhead1">Synopsis</p>
<pre dir="ltr">keytool [<span class="variable">commands</span>]
</pre>
<dl>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-B118C546-1800-4C12-B9B6-A67EE0787EA5"><!-- --></a><code class="codeph"><span class="variable">commands</span></code></dt>
<dd>
<p>See <a href="#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDFFCBG">Commands</a>. These commands are categorized by task as follows:</p>
<ul style="list-style-type: disc;">
<li>
<p style="margin: 0px;">Create or Add Data to the Keystore: <code class="codeph">-gencert</code>, <code class="codeph">-genkeypair</code>, <code class="codeph">-genseckey</code>, <code class="codeph">-importcert</code>, <code class="codeph">-importpass</code></p>
</li>
<li>
<p style="margin: 0px;">Import Contents From Another Keystore: <code class="codeph">-importkeystore</code></p>
</li>
<li>
<p style="margin: 0px;">Generate Certificate Request: <code class="codeph">-certreq</code></p>
</li>
<li>
<p style="margin: 0px;">Export Data: <code class="codeph">-exportcert</code></p>
</li>
<li>
<p style="margin: 0px;">Display Data: <code class="codeph">-list</code>, <code class="codeph">-printcert</code>, <code class="codeph">-printcertreq</code>, <code class="codeph">-printcrl</code></p>
</li>
<li>
<p style="margin: 0px;">Manage the Keystore: <code class="codeph">-storepasswd</code>, <code class="codeph">-keypasswd</code>, <code class="codeph">-delete</code>, <code class="codeph">-changealias</code></p>
</li>
<li>
<p style="margin: 0px;">Get Help: <code class="codeph">-help</code></p>
</li>
</ul>
</dd>
</dl>
</div>
<!-- class="section" -->
<div class="section">
<p class="subhead1">Description</p>
<p>The <code class="codeph">keytool</code> command is a key and certificate management utility. It enables users to administer their own public/private key pairs and associated certificates for use in self-authentication (where the user authenticates himself or herself to other users and services) or data integrity and authentication services, using digital signatures. The <code class="codeph">keytool</code> command also enables users to cache the public keys (in the form of certificates) of their communicating peers.</p>
<p>A certificate is a digitally signed statement from one entity (person, company, and so on.), that says that the public key (and some other information) of some other entity has a particular value. When data is digitally signed, the signature can be verified to check the data integrity and authenticity. Integrity means that the data hasn???t been modified or tampered with, and authenticity means the data comes from whoever claims to have created and signed it.</p>
<p>The <code class="codeph">keytool</code> command also enables users to administer secret keys and passphrases used in symmetric encryption and decryption (DES).</p>
<p>The <code class="codeph">keytool</code> command stores the keys and certificates in a keystore.</p>
</div>
<!-- class="section" -->
<div class="section">
<p class="subhead1">Command and Option Notes</p>
<p>See <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDFFCBG">Commands</a> for a listing and description of the various commands.</p>
<ul style="list-style-type: disc;">
<li>
<p>All command and option names are preceded by a hyphen sign (-).</p>
</li>
<li>
<p>The options for each command can be provided in any order.</p>
</li>
<li>
<p>All items not italicized or in braces or brackets are required to appear as is.</p>
</li>
<li>
<p>Braces surrounding an option signify that a default value will be used when the option isn???t specified on the command line. Braces are also used around the <code class="codeph">-v</code>, <code class="codeph">-rfc</code>, and <code class="codeph">-J</code> options, which only have meaning when they appear on the command line. They don???t have any default values other than not existing.</p>
</li>
<li>
<p>Brackets surrounding an option signify that the user is prompted for the values when the option isn???t specified on the command line. For the <code class="codeph">-keypass</code> option, if you don???t specify the option on the command line, then the <code class="codeph">keytool</code> command first attempts to use the keystore password to recover the private/secret key. If this attempt fails, then the <code class="codeph">keytool</code> command prompts you for the private/secret key password.</p>
</li>
<li>
<p>Items in italics (option values) represent the actual values that must be supplied. For example, here is the format of the <code class="codeph">-printcert</code> command:</p>
<pre dir="ltr">keytool -printcert {-file <span class="variable">cert_file</span>} {-v}
</pre>
<p>When you specify a <code class="codeph">-printcert</code> command, replace <span class="italic"><code class="codeph">cert_file</code></span> with the actual file name, as follows: <code class="codeph">keytool -printcert -file VScert.cer</code></p>
</li>
<li>
<p>Option values must be put in quotation marks when they contain a blank (space).</p>
</li>
<li>
<p>The <code class="codeph">-help</code> option is the default. The <code class="codeph">keytool</code> command is the same as <code class="codeph">keytool -help</code>.</p>
</li>
</ul>
</div>
<!-- class="section" -->
<div class="section">
<p class="subhead1"></p>
</div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDFFCBG">
<p class="subhead1">Commands</p>
<dl>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_GENCERT"><!-- --></a><code class="codeph">-gencert</code></dt>
<dd>
<pre dir="ltr">{-rfc} {-infile <span class="variable">infile</span>} {-outfile <span class="variable">outfile</span>} {-alias <span class="variable">alias</span>} {-sigalg <span class="variable">sigalg</span>}
</pre>
<pre dir="ltr">{-dname <span class="variable">dname</span>} {-startdate <span class="variable">startdate</span> {-ext <span class="variable">ext</span>}* {-validity <span class="variable">valDays</span>}
</pre>
<pre dir="ltr">[-keypass <span class="variable">keypass</span>] {-keystore <span class="variable">keystore</span>} [-storepass <span class="variable">storepass</span>]
</pre>
<pre dir="ltr">{-storetype <span class="variable">storetype</span>} {-providername <span class="variable">provider_name</span>}
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}}
</pre>
<pre dir="ltr">{-v} {-protected} {-Jjavaoption}
</pre>
<p>Generates a certificate as a response to a certificate request file (which can be created by the <code class="codeph">keytool</code> <code class="codeph">-certreq</code> command). The command reads the request from<code class="codeph"><span class="variable">infile</span></code> (if omitted, from the standard input), signs it using alias's private key, and outputs the X.509 certificate into <span class="italic">outfile</span> (if omitted, to the standard output). When<code class="codeph">-rfc</code> is specified, the output format is Base64-encoded PEM; otherwise, a binary DER is created.</p>
<p>The <code class="codeph"><span class="variable">sigalg</span></code> value specifies the algorithm that should be used to sign the certificate. The <code class="codeph">startdate</code> argument is the start time and date that the certificate is valid. The <code class="codeph">valDays</code> argument tells the number of days for which the certificate should be considered valid.</p>
<p>When <code class="codeph"><span class="variable">dname</span></code> is provided, it is used as the subject of the generated certificate. Otherwise, the one from the certificate request is used.</p>
<p>The <code class="codeph"><span class="variable">ext</span></code> value shows what X.509 extensions will be embedded in the certificate. Read Common Options for the grammar of <code class="codeph">-ext</code>.</p>
<p>The <code class="codeph"><span class="variable">-gencert</span></code> option enables you to create certificate chains. The following example creates a certificate, <code class="codeph">e1</code>, that contains three certificates in its certificate chain.</p>
<p>The following commands creates four key pairs named <code class="codeph">ca</code>, <code class="codeph">ca1</code>, <code class="codeph">ca2</code>, and <code class="codeph">e1</code>:</p>
<pre dir="ltr">keytool -alias ca -dname CN=CA -genkeypair
keytool -alias ca1 -dname CN=CA -genkeypair
keytool -alias ca2 -dname CN=CA -genkeypair
keytool -alias e1 -dname CN=E1 -genkeypair
</pre>
<p>The following two commands create a chain of signed certificates; <code class="codeph">ca</code> signs <code class="codeph">ca1</code> and <code class="codeph">ca1</code> signs <code class="codeph">ca2</code>, all of which are self-issued:</p>
<pre dir="ltr">keytool -alias ca1 -certreq |
    keytool -alias ca -gencert -ext san=dns:ca1 |
    keytool -alias ca1 -importcert

keytool -alias ca2 -certreq |
keytool -alias ca1 -gencert -ext san=dns:ca2 |
keytool -alias ca2 -importcert
</pre>
<p>The following command creates the certificate <code class="codeph">e1</code> and stores it in the file <code class="codeph">e1.cert</code>, which is signed by <code class="codeph">ca2</code>. As a result, <code class="codeph">e1</code> should contain <code class="codeph">ca</code>, <code class="codeph">ca1</code>, and <code class="codeph">ca2</code> in its certificate chain:</p>
<pre dir="ltr">keytool -alias e1 -certreq | keytool -alias ca2 -gencert &gt; e1.cert
</pre></dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_GENKEYPAIR"><!-- --></a><code class="codeph">-genkeypair</code></dt>
<dd>
<pre dir="ltr">{-alias <span class="variable">alias</span>} {-keyalg <span class="variable">keyalg</span>} {-keysize <span class="variable">keysize</span>} {-sigalg <span class="variable">sigalg</span>}
</pre>
<pre dir="ltr">[-dname <span class="variable">dname</span>] [-keypass <span class="variable">keypass</span>] {-startdate <span class="variable">value</span>} {-ext <span class="variable">ext</span>}*
</pre>
<pre dir="ltr">{-validity <span class="variable">valDays</span>} {-storetype <span class="variable">storetype</span>} {-keystore <span class="variable">keystore</span>} 
</pre>
<pre dir="ltr">[-storepass <span class="variable">storepass</span>]
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}}
</pre>
<pre dir="ltr">{-v} {-protected} {-Jjavaoption}
</pre>
<p>Generates a key pair (a public key and associated private key). Wraps the public key into an X.509 v3 self-signed certificate, which is stored as a single-element certificate chain. This certificate chain and the private key are stored in a new keystore entry identified by alias.</p>
<p>The <code class="codeph">keyalg</code> value specifies the algorithm to be used to generate the key pair, and the <code class="codeph">keysize</code> value specifies the size of each key to be generated. The <code class="codeph">sigalg</code> value specifies the algorithm that should be used to sign the self-signed certificate. This algorithm must be compatible with the <code class="codeph">keyalg</code> value.</p>
<p>The <code class="codeph">dname</code> value specifies the X.500 Distinguished Name to be associated with the value of <code class="codeph">alias</code>, and is used as the issuer and subject fields in the self-signed certificate. If no distinguished name is provided at the command line, then the user is prompted for one.</p>
<p>The value of <code class="codeph">keypass</code> is a password used to protect the private key of the generated key pair. If no password is provided, then the user is prompted for it. If you press the <span class="bold">Return</span> key at the prompt, then the key password is set to the same password as the keystore password. The <code class="codeph">keypass</code> value must be at least 6 characters.</p>
<p>The value of <code class="codeph">startdate</code> specifies the issue time of the certificate, also known as the "Not Before" value of the X.509 certificate's Validity field.</p>
<p>The option value can be set in one of these two forms:</p>
<p><code class="codeph">([+-]nnn[ymdHMS])+</code></p>
<p><code class="codeph">[yyyy/mm/dd] [HH:MM:SS]</code></p>
<p>With the first form, the issue time is shifted by the specified value from the current time. The value is a concatenation of a sequence of subvalues. Inside each subvalue, the plus sign (+) means shift forward, and the minus sign (-) means shift backward. The time to be shifted is <code class="codeph">nnn</code> units of years, months, days, hours, minutes, or seconds (denoted by a single character of <code class="codeph">y</code>, <code class="codeph">m</code>, <code class="codeph">d</code>, <code class="codeph">H</code>, <code class="codeph">M</code>, or <code class="codeph">S</code> respectively). The exact value of the issue time is calculated using the <code class="codeph">java.util.GregorianCalendar.add(int field, int amount)</code> method on each subvalue, from left to right. For example, the issue time can be specified by:</p>
<pre dir="ltr">Calendar c = new GregorianCalendar();
c.add(Calendar.YEAR, -1);
c.add(Calendar.MONTH, 1);
c.add(Calendar.DATE, -1);
return c.getTime()
</pre>
<p>With the second form, the user sets the exact issue time in two parts, year/month/day and hour:minute:second (using the local time zone). The user can provide only one part, which means the other part is the same as the current date (or time). The user must provide the exact number of digits as shown in the format definition (padding with 0 when shorter). When both the date and time are provided, there is one (and only one) space character between the two parts. The hour should always be provided in 24 hour format.</p>
<p>When the option isn???t provided, the start date is the current time. The option can be provided at most once.</p>
<p>The value of <code class="codeph">valDays</code> specifies the number of days (starting at the date specified by <code class="codeph">-startdate</code>, or the current date when <code class="codeph">-startdate</code> isn???t specified) for which the certificate should be considered valid.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_GENSECKEY"><!-- --></a><code class="codeph">-genseckey</code></dt>
<dd>
<pre dir="ltr">{-alias <span class="variable">alias</span>} {-keyalg <span class="variable">keyalg</span>} {-keysize <span class="variable">keysize</span>} [-keypass <span class="variable">keypass</span>]
</pre>
<pre dir="ltr">{-storetype <span class="variable">storetype</span>} {-keystore <span class="variable">keystore</span>} [-storepass <span class="variable">storepass</span>] 
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}} {-v}
</pre>
<pre dir="ltr">{-protected} {-Jjavaoption}
</pre>
<p>Generates a secret key and stores it in a new <code class="codeph">KeyStore.SecretKeyEntry</code> identified by <code class="codeph">alias</code>.</p>
<p>The value of <code class="codeph">keyalg</code> specifies the algorithm to be used to generate the secret key, and the value of <code class="codeph">keysize</code> specifies the size of the key to be generated. The <code class="codeph">keypass</code> value is a password that protects the secret key. If no password is provided, then the user is prompted for it. If you press the <span class="bold">Return</span> key at the prompt, then the key password is set to the same password that is used for the <code class="codeph">keystore</code>. The <code class="codeph">keypass</code> value must be at least 6 characters.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_IMPORTCERT"><!-- --></a><code class="codeph" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__IMPORTCERT-8EC14583">-importcert</code></dt>
<dd>
<pre dir="ltr">{-alias <span class="variable">alias</span>} {-file <span class="variable">cert_file</span>} [-keypass <span class="variable">keypass</span>] {-noprompt} {-trustcacerts}
</pre>
<pre dir="ltr">{-storetype <span class="variable">storetype</span>} {-keystore <span class="variable">keystore</span>} {-cacerts <span class="variable">cacerts</span>}[-storepass <span class="variable">storepass</span>]
</pre>
<pre dir="ltr">{-providerName <span class="variable">provider_name</span>}
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}}
</pre>
<pre dir="ltr">{-v} {-protected} {-Jjavaoption}
</pre>
<p>Reads the certificate or certificate chain (where the latter is supplied in a PKCS#7 formatted reply or a sequence of X.509 certificates) from the file <code class="codeph">cert_file</code>, and stores it in the <code class="codeph">keystore</code> entry identified by <code class="codeph">alias</code>. If no file is specified, then the certificate or certificate chain is read from <code class="codeph">stdin</code>.</p>
<p>The <code class="codeph">keytool</code> command can import X.509 v1, v2, and v3 certificates, and PKCS#7 formatted certificate chains consisting of certificates of that type. The data to be imported must be provided either in binary encoding format or in printable encoding format (also known as Base64 encoding) as defined by the Internet RFC 1421 standard. In the latter case, the encoding must be bounded at the beginning by a string that starts with <code class="codeph">-</code><code class="codeph">----BEGIN</code>, and bounded at the end by a string that starts with <code class="codeph">-----END</code>.</p>
<p>You import a certificate for two reasons: To add it to the list of trusted certificates, and to import a certificate reply received from a certificate authority (CA) as the result of submitting a Certificate Signing Request to that CA (see <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_CERTREQ">"-certreq"</a> option in <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDFFCBG">Commands</a>).</p>
<p>Which type of import is intended is indicated by the value of the <code class="codeph">-alias</code> option. If the alias doesn???t point to a key entry, then the <code class="codeph">keytool</code> command assumes you are adding a trusted certificate entry. In this case, the alias shouldn???t already exist in the keystore. If the alias does already exist, then the <code class="codeph">keytool</code> command outputs an error because there is already a trusted certificate for that alias, and doesn???t import the certificate. If the alias points to a key entry, then the <code class="codeph">keytool</code> command assumes you are importing a certificate reply.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_IMPORTPASSWORD"><!-- --></a><code class="codeph">-importpass</code></dt>
<dd>
<pre dir="ltr">{-alias <span class="variable">alias</span>} [-keypass <span class="variable">keypass</span>] {-storetype <span class="variable">storetype</span>} {-keystore <span class="variable">keystore</span>}
</pre>
<pre dir="ltr">[-storepass <span class="variable">storepass</span>]
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}}
</pre>
<pre dir="ltr">{-v} {-protected} {-Jjavaoption}
</pre>
<p>Imports a passphrase and stores it in a new <code class="codeph">KeyStore.SecretKeyEntry</code> identified by <code class="codeph">alias</code>. The passphrase may be supplied via the standard input stream; otherwise the user is prompted for it. <code class="codeph">keypass</code> is a password used to protect the imported passphrase. If no password is provided, the user is prompted for it. If you press the <span class="bold">Return</span> key at the prompt, the key password is set to the same password as that used for the <code class="codeph">keystore</code>. <code class="codeph">keypass</code> must be at least 6 characters long.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_IMPORTKEYSTORE"><!-- --></a><code class="codeph">-importkeystore</code></dt>
<dd>
<pre dir="ltr"> -srckeystore <span class="variable">srckeystore</span> {-destkeystore <span class="variable">destkeystore</span>}
</pre>
<div class="infobox-note" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-46687289-8354-4022-84C3-20BD4AFB9595">
<p class="notep1">Note:</p>
<p>This is the first line of all options.</p>
</div>
<pre dir="ltr">{-srcstoretype <span class="variable">srcstoretype</span>} {-deststoretype <span class="variable">deststoretype</span>}
</pre>
<pre dir="ltr">[-srcstorepass <span class="variable">srcstorepass</span>] [-deststorepass <span class="variable">deststorepass</span>] {-srcprotected}
</pre>
<pre dir="ltr">{-destprotected} 
</pre>
<pre dir="ltr">{-srcalias <span class="variable">srcalias</span> {-destalias <span class="variable">destalias</span>} [-srckeypass <span class="variable">srckeypass</span>]} 
</pre>
<pre dir="ltr">[-destkeypass <span class="variable">destkeypass</span>] {-noprompt}
</pre>
<pre dir="ltr">{-srcProviderName <span class="variable">src_provider_name</span>} {-destProviderName <span class="variable">dest_provider_name</span>}
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}} {-v}
</pre>
<pre dir="ltr">{-protected} {-Jjavaoption}
</pre>
<p>Imports a single entry or all entries from a source keystore to a destination keystore.</p>
<div class="infobox-note" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-C76FE57A-5DF4-43AF-9C34-B555AC08E25C">
<p class="notep1">Note:</p>
<p>When using the keytool <code class="codeph">-importkeystore</code> command, if <code class="codeph">-destkeystore</code> is not specified, the default keystore used is <code class="codeph">$HOME/.keystore</code>.</p>
</div>
<p>When the <code class="codeph">-srcalias</code> option is provided, the command imports the single entry identified by the alias to the destination keystore. If a destination alias isn???t provided with <code class="codeph">destalias</code>, then <code class="codeph">srcalias</code> is used as the destination alias. If the source entry is protected by a password, then <code class="codeph">srckeypass</code> is used to recover the entry. If <span class="italic">srckeypass</span> isn???t provided, then the <code class="codeph">keytool</code> command attempts to use <code class="codeph">srcstorepass</code> to recover the entry. If <code class="codeph">srcstorepass</code> is either not provided or is incorrect, then the user is prompted for a password. The destination entry is protected with <code class="codeph">destkeypass</code>. If <code class="codeph">destkeypass</code> isn???t provided, then the destination entry is protected with the source entry password. For example, most third-party tools require <code class="codeph">storepass</code> and <code class="codeph">keypass</code> in a PKCS #12 keystore to be the same. In order to create a PKCS#12 keystore for these tools, always specify a <code class="codeph">-destkeypass</code> to be the same as <code class="codeph">-deststorepass</code>.</p>
<p>If the <code class="codeph">-srcalias</code> option isn???t provided, then all entries in the source keystore are imported into the destination keystore. Each destination entry is stored under the alias from the source entry. If the source entry is protected by a password, then <code class="codeph">srcstorepass</code> is used to recover the entry. If <code class="codeph">srcstorepass</code> is either not provided or is incorrect, then the user is prompted for a password. If a source keystore entry type isn???t supported in the destination keystore, or if an error occurs while storing an entry into the destination keystore, then the user is prompted whether to skip the entry and continue or to quit. The destination entry is protected with the source entry password.</p>
<p>If the destination alias already exists in the destination keystore, then the user is prompted to either overwrite the entry or to create a new entry under a different alias name.</p>
<p>If the <code class="codeph">-noprompt</code> option is provided, then the user isn???t prompted for a new destination alias. Existing entries are overwritten with the destination alias name. Entries that can???t be imported are skipped and a warning is displayed.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__BGBIIIFD"><!-- --></a><code class="codeph">-printcertreq</code></dt>
<dd>
<pre dir="ltr">{-file <span class="variable">file</span>}
</pre>
<p>Prints the content of a PKCS #10 format certificate request, which can be generated by the <code class="codeph">keytool</code> <code class="codeph">-certreq</code> command. The command reads the request from file. If there is no file, then the request is read from the standard input.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_CERTREQ"><!-- --></a><code class="codeph">-certreq</code></dt>
<dd>
<pre dir="ltr">{-alias <span class="variable">alias</span>} {-dname <span class="variable">dname</span>} {-sigalg <span class="variable">sigalg</span>} {-ext  <span class="variable">ext</span>}* {-file <span class="variable">certreq_file</span>}
</pre>
<pre dir="ltr">[-keypass <span class="variable">keypass</span>] {-storetype <span class="variable">storetype</span>} {-keystore <span class="variable">keystore</span>}
</pre>
<pre dir="ltr">[-storepass <span class="variable">storepass</span>] {-providerName <span class="variable">provider_name</span>}
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}}
</pre>
<pre dir="ltr">{-v} {-protected} {-Jjavaoption}
</pre>
<p>Generates a Certificate Signing Request (CSR) using the PKCS #10 format.</p>
<p>A CSR is intended to be sent to a certificate authority (CA). The CA authenticates the certificate requestor (usually off-line) and will return a certificate or certificate chain, used to replace the existing certificate chain (which initially consists of a self-signed certificate) in the keystore.</p>
<p>The private key associated with alias is used to create the PKCS #10 certificate request. To access the private key, the correct password must be provided. If <code class="codeph">keypass</code> isn???t provided at the command line and is different from the password used to protect the integrity of the keystore, then the user is prompted for it. If <code class="codeph">dname</code> is provided, then it is used as the subject in the CSR. Otherwise, the X.500 Distinguished Name associated with alias is used.</p>
<p>The <code class="codeph">sigalg</code> value specifies the algorithm that should be used to sign the CSR.</p>
<p>The CSR is stored in the file certreq_file. If no file is specified, then the CSR is output to <code class="codeph">stdout</code>.</p>
<p>Use the <code class="codeph">importcert</code> command to import the response from the CA.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_EXPORTCERT"><!-- --></a><code class="codeph">-exportcert</code></dt>
<dd>
<pre dir="ltr">{-alias <span class="variable">alias</span>} {-file <span class="variable">cert_file</span>} {-storetype <span class="variable">storetype</span>} {-keystore <span class="variable">keystore</span>}{-cacerts <span class="variable">cacerts</span>}
</pre>
<pre dir="ltr">[-storepass <span class="variable">storepass</span>] {-providerName <span class="variable">provider_name</span>}
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}}
</pre>
<pre dir="ltr">{-rfc} {-v} {-protected} {-Jjavaoption}
</pre>
<p>Reads from the keystore the certificate associated with <span class="italic">alias</span> and stores it in the cert_file file. When no file is specified, the certificate is output to <code class="codeph">stdout</code>.</p>
<p>The certificate is by default output in binary encoding. If the <code class="codeph">-rfc</code> option is specified, then the output in the printable encoding format defined by the <cite>Internet RFC 1421 Certificate Encoding Standard</cite>.</p>
<p>If <code class="codeph">alias</code> refers to a trusted certificate, then that certificate is output. Otherwise, <code class="codeph">alias</code> refers to a key entry with an associated certificate chain. In that case, the first certificate in the chain is returned. This certificate authenticates the public key of the entity addressed by <code class="codeph">alias</code>.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_LIST"><!-- --></a><code class="codeph">-list</code></dt>
<dd>
<pre dir="ltr">{-alias <span class="italic">alias</span>} {-storetype <span class="italic">storetype</span>} {-keystore <span class="italic">keystore</span>} {-cacerts <span class="italic">cacerts</span>}[-storepass <span class="italic">storepass</span>]
</pre>
<pre dir="ltr">{-providerName <span class="italic">provider_name</span>}
</pre>
<pre dir="ltr">{-providerClass <span class="italic">provider_class_name</span> {-providerArg <span class="italic">provider_arg</span>}}
</pre>
<pre dir="ltr">{-v | -rfc} {-protected} {-Jjavaoption}
</pre>
<p>Prints to <code class="codeph">stdout</code> the contents of the keystore entry identified by <code class="codeph">alias</code>. If no <code class="codeph">alias</code> is specified, then the contents of the entire keystore are printed.</p>
<p>This command by default prints the SHA-256 fingerprint of a certificate. If the <code class="codeph">-v</code> option is specified, then the certificate is printed in human-readable format, with additional information such as the owner, issuer, serial number, and any extensions. If the <code class="codeph">-rfc</code> option is specified, then the certificate contents are printed using the printable encoding format, as defined by the <cite>Internet RFC 1421 Certificate Encoding Standard</cite>.</p>
<p>You can???t specify both <code class="codeph">-v</code> and <code class="codeph">-rfc</code>.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_PRINTCERT"><!-- --></a><code class="codeph">-printcert</code></dt>
<dd>
<pre dir="ltr">{-file <span class="italic">cert_file</span> | -sslserver <span class="italic">host</span>[:<span class="italic">port</span>]} {-jarfile <span class="italic">JAR_file</span> {-rfc} {-v}
</pre>
<pre dir="ltr">{-Jjavaoption}
</pre>
<p>Reads the certificate from the file cert_file, the SSL server located at host:port, or the signed JAR file <code class="codeph">JAR_file</code> (with the <code class="codeph">-jarfile</code> option and prints its contents in a human-readable format. When no port is specified, the standard HTTPS port 443 is assumed. Note that <code class="codeph">-sslserver</code> and -file options can???t be provided at the same time. Otherwise, an error is reported. If neither option is specified, then the certificate is read from <code class="codeph">stdin</code>.</p>
<p>When<code class="codeph">-rfc</code> is specified, the <code class="codeph">keytool</code> command prints the certificate in PEM mode as defined by the <cite>Internet RFC 1421 Certificate Encoding</cite> standard.</p>
<p>If the certificate is read from a file or <code class="codeph">stdin</code>, then it might be either binary encoded or in printable encoding format, as defined by the RFC 1421 Certificate Encoding standard.</p>
<p>If the SSL server is behind a firewall, then the <code class="codeph">-J-Dhttps.proxyHost=proxyhost</code> and <code class="codeph">-J-Dhttps.proxyPort=proxyport</code> options can be specified on the command line for proxy tunneling.</p>
<p><span class="bold">Note:</span> This option can be used independently of a keystore.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_PRINTCRL"><!-- --></a><code class="codeph">-printcrl</code></dt>
<dd>
<pre dir="ltr">-file <span class="variable">crl_</span> {-v}
</pre>
<p>Reads the Certificate Revocation List (CRL) from the file <code class="codeph"><span class="variable">crl_</span></code>. A CRL is a list of digital certificates that were revoked by the CA that issued them. The CA generates the <code class="codeph"><span class="variable">crl_</span></code> file.</p>
<p><span class="bold">Note:</span> This option can be used independently of a keystore.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_STOREPASSWD"><!-- --></a><code class="codeph">-storepasswd</code></dt>
<dd>
<pre dir="ltr">[-new <span class="variable">new_storepass</span>] {-storetype <span class="variable">storetype</span>} {-keystore <span class="variable">keystore</span>}{-cacerts <span class="variable">cacerts</span>}
</pre>
<pre dir="ltr">[-storepass <span class="variable">storepass</span>] {-providerName <span class="variable">provider_name</span>}
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}}
</pre>
<pre dir="ltr">{-v} {-Jjavaoption}
</pre>
<p>Changes the password used to protect the integrity of the keystore contents. The new password is <code class="codeph">new_storepass</code>, which must be at least 6 characters.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_KEYPASSWD"><!-- --></a><code class="codeph">-keypasswd</code></dt>
<dd>
<pre dir="ltr">{-alias <span class="variable">alias</span>} [-keypass <span class="variable">old_keypass</span>] [-new <span class="variable">new_keypass</span>] {-storetype <span class="variable">storetype</span>}
</pre>
<pre dir="ltr">{-keystore <span class="variable">keystore</span>}  [-storepass <span class="variable">storepass</span>] {-providerName <span class="variable">provider_name</span>}
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}} {-v}
</pre>
<pre dir="ltr">{-Jjavaoption}
</pre>
<p>Changes the password under which the private/secret keys identified by <code class="codeph">alias</code> is protected, from <code class="codeph">old_keypass</code> to <code class="codeph">new_keypass</code>, which must be at least 6 characters.</p>
<p>If the <code class="codeph">-keypass</code> option isn???t provided at the command line, and the key password is different from the keystore password, then the user is prompted for it.</p>
<p>If the <code class="codeph">-new</code> option isn???t provided at the command line, then the user is prompted for it</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_DELETE"><!-- --></a><code class="codeph">-delete</code></dt>
<dd>
<pre dir="ltr">[-alias <span class="variable">alias</span>] {-storetype <span class="variable">storetype</span>} {-keystore <span class="variable">keystore</span>} {-cacerts <span class="variable">cacerts</span>}[-storepass <span class="variable">storepass</span>]
</pre>
<pre dir="ltr">{-providerName <span class="variable">provider_name</span>}  
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}}
</pre>
<pre dir="ltr">{-v} {-protected} {-Jjavaoption}
</pre>
<p>Deletes from the keystore the entry identified by <code class="codeph">alias</code>. The user is prompted for the alias, when no alias is provided at the command line.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_CHANGEALIAS"><!-- --></a><code class="codeph">-changealias</code></dt>
<dd>
<pre dir="ltr">{-alias <span class="variable">alias</span>} [-destalias <span class="variable">destalias</span>] [-keypass <span class="variable">keypass</span>] {-storetype <span class="variable">storetype</span>}
</pre>
<pre dir="ltr">{-keystore <span class="variable">keystore</span>}{-cacerts <span class="variable">cacerts</span>} [-storepass <span class="variable">storepass</span>] {-providerName <span class="variable">provider_name</span>}
</pre>
<pre dir="ltr">{-providerClass <span class="variable">provider_class_name</span> {-providerArg <span class="variable">provider_arg</span>}} {-v}
</pre>
<pre dir="ltr">{-protected} {-Jjavaoption}
</pre>
<p>Move an existing keystore entry from the specified <code class="codeph">alias</code> to a new alias, <code class="codeph">destalias</code>. If no destination alias is provided, then the command prompts for one. If the original entry is protected with an entry password, then the password can be supplied with the <code class="codeph">-keypass</code> option. If no key password is provided, then the <code class="codeph">storepass</code> (if provided) is attempted first. If the attempt fails, then the user is prompted for a password.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_HELP"><!-- --></a><code class="codeph">???help</code></dt>
<dd>
<p>Lists the basic commands and their options.</p>
<p>For more information about a specific command, enter the following, where <code class="codeph"><span class="codeinlineitalic">command_name</span></code> is the name of the command: <code class="codeph">keytool -<span class="variable">command_name</span> -help</code>.</p>
</dd>
</dl>
</div>
<!-- class="section" -->
<div class="section">
<p class="subhead1">Common Options</p>
<p>The <code class="codeph">-v</code> option can appear for all commands except <code class="codeph">-help</code>. When the <code class="codeph">-v</code> option appears, it signifies verbose mode, which means that more information is provided in the output.</p>
<p>There is also a <code class="codeph">-Jjavaoption</code> argument that can appear for any command. When the <code class="codeph">-Jjavaoption</code> appears, the specified <code class="codeph">javaoption</code> string is passed directly to the Java interpreter. This option doesn???t contain any spaces. It is useful for adjusting the execution environment or memory usage. For a list of possible <a href="#GUID-3B1CE181-CD30-4178-9602-230B800D4FAE__CBBIJCHG">interpreter options</a>, type <code class="codeph">java -h</code> or <code class="codeph">java -X</code> at the command line.</p>
<p>These options can appear for all commands operating on a keystore:</p>
<dl class="0.99* 3.01*">
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-A6FFD7D5-23A1-49AB-BB13-7BB3FD46733C"><!-- --></a><code class="codeph">-storetype <span class="variable">storetype</span></code></dt>
<dd>
<p>This qualifier specifies the type of keystore to be instantiated.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-7C596C68-3B62-4DC4-8AF7-6AC472233DF6"><!-- --></a><code class="codeph">-keystore <span class="variable">keystore</span></code></dt>
<dd>
<p>The keystore location.</p>
<p>If the JKS <code class="codeph">storetype</code> is used and a keystore file doesn???t yet exist, then certain <code class="codeph">keytool</code> commands can result in a new keystore file being created. For example, if <code class="codeph">keytool -genkeypair</code> is called and the <code class="codeph">-keystore</code> option isn???t specified, the default keystore file named <code class="codeph">.keystore</code> in the user's home directory is created when it doesn???t already exist. Similarly, if the <code class="codeph">-keystore ks_file</code> option is specified but ks_file doesn???t exist, then it is created. For more information on the JKS <code class="codeph">storetype</code>, see <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-A8B9E662-C1C2-4A0E-9307-A8464F0E95D4">"KeyStore Implementation"</a> section in <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDJHCAA">"KeyStore aliases"</a>.</p>
<p>Note that the input stream from the <code class="codeph">-keystore</code> option is passed to the <code class="codeph">KeyStore.load</code> method. If <code class="codeph">NONE</code> is specified as the URL, then a null stream is passed to the <code class="codeph">KeyStore.load</code> method. <code class="codeph">NONE</code> should be specified if the keystore isn???t file-based. For example, when it resides on a hardware token device.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-5FB24101-D774-4104-A498-2C6313969E2C"><!-- --></a><code class="codeph">-cacerts <span class="variable">cacerts</span></code></dt>
<dd>
<p>Operates on the <code class="codeph">cacerts</code> keystore . This option is &nbsp;equivalent to <code class="codeph">"-keystore path_to_cacerts -storetype type_of_cacerts"</code>. An error will be reported if the<code class="codeph">-keystore</code> or <code class="codeph">-storetype</code> option is used with the <code class="codeph">-cacerts</code> option.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-2055E8D1-AF47-489F-93CE-7857BB73EF2F"><!-- --></a><code class="codeph">-storepass [:<span class="variable">env</span> | :<span class="variable">file</span> ] argument</code></dt>
<dd>
<p>The password that is used to protect the integrity of the keystore.</p>
<p>If the modifier <code class="codeph">env</code> or <code class="codeph">file</code> isn???t specified, then the password has the <code class="codeph">value</code> argument, which must be at least 6 characters long. Otherwise, the password is retrieved as follows:</p>
<ul style="list-style-type: disc;">
<li>
<p style="margin: 0px;"><code class="codeph">env</code>: Retrieve the password from the environment variable named <code class="codeph">argument</code>.</p>
</li>
<li>
<p style="margin: 0px;"><code class="codeph">file</code>: Retrieve the password from the file named argument.</p>
</li>
</ul>
<p><span class="bold">Note:</span> All other options that require passwords, such as <code class="codeph">-keypass</code>, <code class="codeph">-srckeypass</code>, -<code class="codeph">destkeypass</code>, <code class="codeph">-srcstorepass</code>, and <code class="codeph">-deststorepass</code>, accept the <code class="codeph"><span class="variable">env</span></code> and <code class="codeph"><span class="variable">file</span></code> modifiers. Remember to separate the password option and the modifier with a colon (:).</p>
<p>The password must be provided to all commands that access the keystore contents. For such commands, when the <code class="codeph">-storepass</code> option isn???t provided at the command line, the user is prompted for it.</p>
<p>When retrieving information from the keystore, the password is optional. If no password is specified, then the integrity of the retrieved information can???t be verified and a warning is displayed.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-49D4DD93-B518-49FB-A7C1-1DAADCB5A66E"><!-- --></a><code class="codeph">-providerName <span class="variable">provider_name</span></code></dt>
<dd>
<p>Used to identify a cryptographic service provider's name when listed in the security properties file.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-1A7FFD97-07E9-406E-B6BA-54B6DA929EA7"><!-- --></a><code class="codeph">-providerClass <span class="variable">provider_class_name</span></code></dt>
<dd>
<p>Used to specify the name of a cryptographic service provider's master class file when the service provider isn???t listed in the security properties file.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-DDCB9F2D-6904-42AE-AAF5-D036D0D100BE"><!-- --></a><code class="codeph">-providerArg <span class="variable">provider_arg</span></code></dt>
<dd>
<p>Used with the <code class="codeph">-providerClass</code> option to represent an optional string input argument for the constructor of <code class="codeph"><span class="variable">provider_class_name</span></code>.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-50610EF1-21B0-485E-8028-31D89E1FD9CA"><!-- --></a><code class="codeph">-protected=true|false</code></dt>
<dd>
<p>This value should be specified as <code class="codeph">true</code> when a password must be specified by way of a protected authentication path such as a dedicated PIN reader.Because there are two keystores involved in the <code class="codeph">-importkeystore</code> command, the following two options <code class="codeph">-srcprotected</code> and -<code class="codeph">destprotected</code> are provided for the source keystore and the destination keystore respectively.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-93FBA77D-2901-416E-A296-8F3364FF929E"><!-- --></a><code class="codeph">-ext <span class="variable">{name{:critical} {=value}}</span></code></dt>
<dd>
<p>Denotes an X.509 certificate extension. The option can be used in <code class="codeph">-genkeypair</code> and <code class="codeph">-gencert</code> to embed extensions into the certificate generated, or in <code class="codeph">-certreq</code> to show what extensions are requested in the certificate request. The option can appear multiple times. The <code class="codeph">name</code> argument can be a supported extension name (see <span class="bold">Named Extensions</span> below) or an arbitrary OID number. The <code class="codeph">value</code> argument, when provided, denotes the argument for the extension. When <code class="codeph"><span class="variable">value</span></code> is omitted, that means that the default value of the extension or the extension requires no argument. The <code class="codeph">:critical</code> modifier, when provided, means the extension's <code class="codeph">isCritical</code> attribute is <code class="codeph">true</code>; otherwise, it is <code class="codeph">false</code>. You can use <code class="codeph">:c</code> in place of <code class="codeph">:critical</code>.</p>
</dd>
</dl>
</div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDGIGAE">
<p class="subhead1">Examples of Option Values</p>
<p>The following examples show the defaults for various option values.</p>
<pre dir="ltr">-alias "mykey"

-keyalg
"DSA" (when using -genkeypair)
"DES" (when using -genseckey)

-keysize
2048 (when using -genkeypair and -keyalg is "RSA")
2048 (when using -genkeypair and -keyalg is "DSA")
256 (when using -genkeypair and -keyalg is "EC")
56 (when using -genseckey and -keyalg is "DES")
168 (when using -genseckey and -keyalg is "DESede")

-validity 90

-keystore &lt;the file named .keystore in the user's home directory&gt;

-destkeystore &lt;the file named .keystore in the user's home directory&gt;

-storetype &lt;the value of the "keystore.type" property in the
security properties file, which is returned by the static
getDefaultType method in java.security.KeyStore&gt;

-file
stdin (if reading)
stdout (if writing)

-protected false
</pre>
<p>In generating a certificate or a certificate request, the default signature algorithm (<code class="codeph">-sigalg</code> option) is derived from the algorithm of the underlying private key to provide an appropriate level of security strength as shown:</p>
<div class="tblformalwide" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-5709F884-DD73-4401-A2FC-C7610922DC53">
<table class="cellalignment186" summary="Default signature algorithms">
<thead>
<tr class="cellalignment180">
<th class="cellalignment187" id="d36699e1779">keyalg</th>
<th class="cellalignment187" id="d36699e1781">keysize</th>
<th class="cellalignment188" id="d36699e1783">default sigalg</th>
</tr>
</thead>
<tbody>
<tr class="cellalignment180">
<td class="cellalignment189" id="d36699e1787" headers="d36699e1779">
<p>DSA</p>
</td>
<td class="cellalignment189" headers="d36699e1787 d36699e1781">
<p>any size</p>
</td>
<td class="cellalignment190" headers="d36699e1787 d36699e1783">
<p>SHA256withDSA &nbsp;&nbsp;</p>
</td>
</tr>
<tr class="cellalignment180">
<td class="cellalignment189" id="d36699e1797" headers="d36699e1779">
<p>RSA</p>
&nbsp;&nbsp;&nbsp;</td>
<td class="cellalignment189" headers="d36699e1797 d36699e1781">
<p>&lt;= 3072</p>
<p>&lt;= 7680</p>
<p>&gt; 7680</p>
</td>
<td class="cellalignment190" headers="d36699e1797 d36699e1783">
<p>SHA256withRSA</p>
<p>SHA384withRSA</p>
<p>SHA512withRSA</p>
</td>
</tr>
<tr class="cellalignment180">
<td class="cellalignment189" id="d36699e1816" headers="d36699e1779">
<p>EC</p>
</td>
<td class="cellalignment189" headers="d36699e1816 d36699e1781">
<p>&lt;384</p>
<p>&lt;512</p>
<p>= 512</p>
</td>
<td class="cellalignment190" headers="d36699e1816 d36699e1783">
<p>SHA256withECDSA</p>
<p>SHA384withECDSA</p>
<p>SHA512withECDSA</p>
</td>
</tr>
</tbody>
</table>
</div>
<!-- class="inftblhruleinformal" -->
<div class="infobox-note" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-64065F29-2298-42DE-8663-B00E7FA62F3C">
<p class="notep1">Note:</p>
<p>In order to improve out of the box security, default key size and signature algorithm names are periodically updated to stronger values with each release of the JDK. If interoperability with older releases of the JDK is important, please make sure the defaults are supported by those releases, or alternatively use the <code class="codeph">-keysize</code> or <code class="codeph">-sigalg</code> options to override the default values at your own risk.</p>
</div>
</div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDGDJDA">
<p class="subhead1">Supported Named Extensions</p>
<p>The <code class="codeph">keytool</code> command supports these named extensions. The names aren???t case-sensitive.</p>
<dl>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-B5233DE8-0628-4D44-A9C9-99132146AD36"><!-- --></a><code class="codeph">BC</code> or <code class="codeph">BasicContraints</code></dt>
<dd>
<p><span class="bold">Values</span>: The full form is: <code class="codeph">ca:{true|false}[,pathlen:<span class="variable">len</span>]</code> or <span class="variable">len</span>, which is short for <code class="codeph">ca:true,pathlen:<span class="variable">len</span></code>. When <span class="variable">len</span>is omitted, you have <code class="codeph">ca:true</code>.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-6E9E9315-1DE4-42E2-95E3-E41975BE77F3"><!-- --></a><code class="codeph">KU</code> or <code class="codeph">KeyUsage</code></dt>
<dd>
<p><span class="bold">Values</span>: <code class="codeph"><span class="variable">usage</span></code>(,<code class="codeph">usage</code>)*, where <span class="italic">usage</span> can be one of <code class="codeph">digitalSignature</code>, <code class="codeph">nonRepudiation (contentCommitment</code> ), <code class="codeph">keyEncipherment</code>, <code class="codeph">dataEncipherment</code>, <code class="codeph">keyAgreement</code>, <code class="codeph">keyCertSign</code>, <code class="codeph">cRLSign</code>, <code class="codeph">encipherOnly</code>, <code class="codeph">decipherOnly</code>. The <code class="codeph"><span class="variable">usage</span></code> argument can be abbreviated with the first few letters (<code class="codeph">dig</code> for <code class="codeph">digitalSignature</code>) or in camel-case style (<code class="codeph">dS</code> for <code class="codeph">digitalSignature</code> or <code class="codeph">cRLS</code> for <code class="codeph">cRLSign</code>), as long as no ambiguity is found. The <code class="codeph">usage</code> values are case-sensitive.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-7A399303-A838-48E7-A0DD-8DB3D83A638C"><!-- --></a><code class="codeph">EKU</code> or <code class="codeph">ExtendedKeyUsage</code></dt>
<dd>
<p><span class="bold">Values</span>: <code class="codeph">usage</code>(,<code class="codeph">usage</code>)*, where <span class="italic">usage</span> can be one of <code class="codeph">anyExtendedKeyUsage</code>, <code class="codeph">serverAuth</code>, <code class="codeph">clientAuth</code>, <code class="codeph">codeSigning</code>, <code class="codeph">emailProtection</code>, <code class="codeph">timeStamping</code>, <code class="codeph">OCSPSigning</code>, or any OID string. The<code class="codeph">usage</code> argument can be abbreviated with the first few letters or in camel-case style, as long as no ambiguity is found. The <code class="codeph">usage</code> values are case-sensitive.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-DE2FA69B-5945-4D95-8742-7D79B0BF02D9"><!-- --></a><code class="codeph">SAN</code> or <code class="codeph">SubjectAlternativeName</code></dt>
<dd>
<p><span class="bold">Values</span>: <code class="codeph">type</code>:<code class="codeph">value</code>(,<code class="codeph">type:value</code>)*, where <code class="codeph"><span class="codeinlineitalic">type</span></code> can be <code class="codeph">EMAIL</code>, <code class="codeph">URI</code>, <code class="codeph">DNS</code>, <code class="codeph">IP</code>, or <code class="codeph">OID</code>. The <code class="codeph"><span class="codeinlineitalic">value</span></code> argument is the string format value for the <code class="codeph"><span class="codeinlineitalic">type</span></code>.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-1D6F47C0-D6B3-46A7-AF34-C5DA4342A47C"><!-- --></a><code class="codeph">IAN</code> or <code class="codeph">IssuerAlternativeName</code></dt>
<dd>
<p><span class="bold">Values</span>: Same as <code class="codeph">SubjectAlternativeName</code>.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-3E572131-9A44-4B87-BCE4-BFBAFDE42CFC"><!-- --></a><code class="codeph">SIA</code> or <code class="codeph">SubjectInfoAccess</code></dt>
<dd>
<p><span class="bold">Values</span>: <code class="codeph">method</code>:<code class="codeph">location-type</code>:<code class="codeph">location-value</code> (,<code class="codeph">method:location-type</code>:<code class="codeph">location-value</code>)*, where <code class="codeph">method</code> can be <code class="codeph">timeStamping</code>, <code class="codeph">caRepository</code> or any OID. The <code class="codeph">location-type</code> and <code class="codeph">location-value</code> arguments can be any <code class="codeph">type</code>:<code class="codeph">value</code> supported by the <code class="codeph">SubjectAlternativeName</code> extension.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-48E64B59-ABC5-4F3C-973C-D61C10D1BE9B"><!-- --></a><code class="codeph">AIA</code> or <code class="codeph">AuthorityInfoAccess</code></dt>
<dd>
<p><span class="bold">Values</span>: Same as <code class="codeph">SubjectInfoAccess</code>. The <code class="codeph">method</code> argument can be <code class="codeph">ocsp</code>,<code class="codeph">caIssuers</code>, or any OID.</p>
</dd>
</dl>
<p>When <code class="codeph">name</code> is OID, the value is the hexadecimal dumped DER encoding of the <code class="codeph">extnValue</code> for the extension excluding the OCTET STRING type and length bytes. Any extra character other than standard hexadecimal numbers (0-9, a-f, A-F) are ignored in the HEX string. Therefore, both 01:02:03:04 and 01020304 are accepted as identical values. When there is no value, the extension has an empty value field.</p>
<p>A special name <code class="codeph">honored</code>, used in <code class="codeph">-gencert</code> only, denotes how the extensions included in the certificate request should be honored. The value for this name is a comma separated list of <code class="codeph">all</code> (all requested extensions are honored), <code class="codeph">name{:[critical|non-critical]}</code> (the named extension is honored, but using a different <code class="codeph">isCritical</code> attribute) and <code class="codeph">-name</code> (used with <code class="codeph">all</code>, denotes an exception). Requested extensions aren???t honored by default.</p>
<p>If, besides the <code class="codeph">-ext honored</code> option, another named or OID <code class="codeph">-ext</code> option is provided, this extension is added to those already honored. However, if this name (or OID) also appears in the honored value, then its value and criticality overrides the one in the request. If extension of the same type is provided multiple times through either a name or an OID, only the last one will be used.</p>
<p>The <code class="codeph">subjectKeyIdentifier</code> extension is always created. For non-self-signed certificates, the <code class="codeph">authorityKeyIdentifier</code> is created.</p>
<p><span class="bold">Note:</span> Users should be aware that some combinations of extensions (and other certificate fields) may not conform to the Internet standard. See <span class="bold">Certificate Conformance Warning</span>..</p>
</div>
<!-- class="section" -->
<div class="section">
<p class="subhead1">Examples of Tasks Performed in Creating a keystore</p>
<p>The following examples describe the sequence actions in creating a keystore for managing public/private key pair and certificates from trusted entities.</p>
<ul style="list-style-type: disc;">
<li>
<p style="margin: 0px;"><a href="#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFGENERATINGTHEKEYPAIR-9BB8757E">Example of Generating the Key Pair</a></p>
</li>
<li>
<p style="margin: 0px;"><a href="#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFREQUESTINGASIGNEDCERTIFICA-9BB87A89">Example of Requesting a Signed Certificate from a CA</a></p>
</li>
<li>
<p style="margin: 0px;"><a href="#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFIMPORTINGACERTIFICATEFORTH-9BB88005">Example of Importing a Certificate for the CA</a></p>
</li>
<li>
<p style="margin: 0px;"><a href="#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFIMPORTINGTHECERTIFICATEREP-9BB88612">Example of Importing the Certificate Reply from the CA</a></p>
</li>
<li>
<p style="margin: 0px;"><a href="#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFEXPORTINGACERTIFICATETHATA-9BB88FBE">Example of Exporting a Certificate That Authenticates the Public Key</a></p>
</li>
<li>
<p style="margin: 0px;"><a href="#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFIMPORTINGKEYSTORE-9BB896E3">Example of Importing Keystore</a></p>
</li>
<li>
<p style="margin: 0px;"><a href="#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFGENERATINGCERTIFICATESFORA-9BB8A562">Example of Generating Certificates for an SSL Server</a></p>
</li>
</ul>
</div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFGENERATINGTHEKEYPAIR-9BB8757E">
<p class="subhead1">Example of Generating the Key Pair</p>
<p>First, create a keystore and generate the key pair. You can use a command such as the following typed as a single line:</p>
<pre dir="ltr">keytool -genkeypair -dname "cn=<span class="variable">myname</span>, ou=<span class="variable">mygroup</span>, o=<span class="variable">mycompany</span>, c=<span class="variable">mycountry</span>"
    -alias business -keypass <span class="variable">password</span>
    -keystore /working/mykeystore
    -storepass <span class="variable">password</span> -validity 180
</pre>
<p>The command creates the keystore named <code class="codeph">mykeystore</code> in the working directory (assuming it doesn???t already exist), and assigns it the password specified by <code class="codeph">&lt;new password for keystore&gt;</code>. It generates a public/private key pair for the entity whose distinguished name has a common name of Mark Jones, organizational unit of Java, organization of Oracle and two-letter country code of US. It uses the default DSA key generation algorithm to create the keys; both are 2048 bits</p>
<p>The command uses the default SHA256withDSA signature algorithm to create a self-signed certificate that includes the public key and the distinguished name information. The certificate is valid for 180 days, and is associated with the private key in a keystore entry referred to by the alias <code class="codeph">business</code>. The private key is assigned the password specified by <code class="codeph"><span class="variable">new password for private key</span></code>.</p>
<p>The command is significantly shorter when the option defaults are accepted. In this case, no options are required, and the defaults are used for unspecified options that have default values. You are prompted for any required values. You could have the following:</p>
<pre dir="ltr">keytool -genkeypair
</pre>
<p>In this case, a keystore entry with the alias <code class="codeph">mykey</code> is created, with a newly generated key pair and a certificate that is valid for 90 days. This entry is placed in the keystore named <code class="codeph">.keystore</code> in your home directory. The keystore is created when it doesn???t already exist. You are prompted for the distinguished name information, the keystore password, and the private key password.</p>
<p>The rest of the examples assume you executed the <code class="codeph">-genkeypair</code> command without options specified, and that you responded to the prompts with values equal to those specified in the first <code class="codeph">-genkeypair</code> command. For example, a distinguished name of <code class="codeph">cn=<span class="variable">myname</span></code>, <code class="codeph">ou=<span class="variable">mygroup</span></code>, <code class="codeph">o=<span class="variable">mycompany</span></code>, <code class="codeph">c=<span class="variable">mycountry</span></code>).</p>
</div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFREQUESTINGASIGNEDCERTIFICA-9BB87A89">
<p class="subhead1">Example of Requesting a Signed Certificate from a CA</p>
<p>Generating the key pair created a self-signed certificate. A certificate is more likely to be trusted by others when it is signed by a Certification Authority (CA). To get a CA signature, first generate a Certificate Signing Request (CSR), as follows:</p>
<pre dir="ltr">keytool -certreq -file <span class="variable">myname</span>.csr
</pre>
<p>This creates a CSR for the entity identified by the default alias <code class="codeph">mykey</code> and puts the request in the file named <code class="codeph"><span class="variable">myname</span>.csr</code>. Submit this file to a CA, such as VeriSign. The CA authenticates you, the requestor (usually off-line), and returns a certificate, signed by them, authenticating your public key. In some cases, the CA returns a chain of certificates, each one authenticating the public key of the signer of the previous certificate in the chain.</p>
</div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFIMPORTINGACERTIFICATEFORTH-9BB88005">
<p class="subhead1">Example of Importing a Certificate for the CA</p>
<p>You now need to replace the self-signed certificate with a certificate chain, where each certificate in the chain authenticates the public key of the signer of the previous certificate in the chain, up to a root CA.</p>
<p>Before you import the certificate reply from a CA, you need one or more trusted certificates in your keystore or in the <code class="codeph">cacerts</code> keystore file. See <a href="#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_IMPORTCERT">"-importcert"</a> in <span class="bold">Commands</span>.</p>
<ul style="list-style-type: disc;">
<li>
<p>If the certificate reply is a certificate chain, then you need the top certificate of the chain. The root CA certificate that authenticates the public key of the CA.</p>
</li>
<li>
<p>If the certificate reply is a single certificate, then you need a certificate for the issuing CA (the one that signed it). If that certificate isn???t self-signed, then you need a certificate for its signer, and so on, up to a self-signed root CA certificate.</p>
</li>
</ul>
<p>The <code class="codeph">cacerts</code> keystore file ships with several VeriSign root CA certificates, so you probably will not need to import a VeriSign certificate as a trusted certificate in your keystore. But if you request a signed certificate from a different CA, and a certificate authenticating that CA's public key wasn???t added to <code class="codeph">cacerts</code>, then you must import a certificate from the CA as a trusted certificate.</p>
<p>A certificate from a CA is usually either self-signed or signed by another CA, in which case you need a certificate that authenticates that CA's public key. Suppose company ABC, Inc., is a CA, and you obtain a file named A<code class="codeph">BCCA.cer</code> that is supposed to be a self-signed certificate from ABC, that authenticates that CA's public key. Be careful to ensure the certificate is valid before you import it as a trusted certificate. View it first with the <code class="codeph">keytool -printcert</code> command or the <code class="codeph">keytool -importcert</code> command without the <code class="codeph">-noprompt</code> option, and make sure that the displayed certificate fingerprints match the expected ones. You can call the person who sent the certificate, and compare the fingerprints that you see with the ones that they show or that a secure public key repository shows. Only when the fingerprints are equal is it guaranteed that the certificate wasn???t replaced in transit with somebody else's (for example, an attacker's) certificate. If such an attack takes place, and you didn???t check the certificate before you imported it, then you would be trusting anything the attacker has signed.</p>
<p>If you trust that the certificate is valid, then you can add it to your keystore with the following command:</p>
<pre dir="ltr">keytool -importcert -alias abc -file ABCCA.cer
</pre>
<p>This command creates a trusted certificate entry in the keystore, with the data from the file ABCCA.cer, and assigns the alias <code class="codeph">abc</code> to the entry.</p>
</div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFIMPORTINGTHECERTIFICATEREP-9BB88612">
<p class="subhead1">Example of Importing the Certificate Reply from the CA</p>
<p>After you import a certificate that authenticates the public key of the CA you submitted your certificate signing request to (or there is already such a certificate in the cacerts file), you can import the certificate reply and replace your self-signed certificate with a certificate chain. This chain is the one returned by the CA in response to your request (when the CA reply is a chain), or one constructed (when the CA reply is a single certificate) using the certificate reply and trusted certificates that are already available in the keystore where you import the reply or in the <code class="codeph">cacerts</code> keystore file.</p>
<p>For example, if you sent your certificate signing request to VeriSign, then you can import the reply with the following, which assumes the returned certificate is named <code class="codeph">VS<span class="variable">myname</span>.cer</code>:</p>
<pre dir="ltr">keytool -importcert -trustcacerts -file VS<span class="variable">myname</span>.cer
</pre></div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFEXPORTINGACERTIFICATETHATA-9BB88FBE">
<p class="subhead1">Example of Exporting a Certificate That Authenticates the Public Key</p>
<p>If you used the <code class="codeph">jarsigner</code> command to sign a Java Archive (JAR) file, then clients that want to use the file will want to authenticate your signature. One way the clients can authenticate you is by first importing your public key certificate into their keystore as a trusted entry.</p>
<p>You can export the certificate and supply it to your clients. As an example, you can copy your certificate to a file named <code class="codeph"><span class="variable">myname</span>.cer</code> with the following command that assumes the entry has an alias of <code class="codeph">mykey</code>:</p>
<pre dir="ltr">keytool -exportcert -alias mykey -file <span class="variable">myname</span>.cer
</pre>
<p>With the certificate and the signed JAR file, a client can use the <code class="codeph">jarsigner</code> command to authenticate your signature.</p>
</div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFIMPORTINGKEYSTORE-9BB896E3">
<p class="subhead1">Example of Importing Keystore</p>
<p>The command <code class="codeph">importkeystore</code> is used to import an entire keystore into another keystore, which means all entries from the source keystore, including keys and certificates, are all imported to the destination keystore within a single command. You can use this command to import entries from a different type of keystore. During the import, all new entries in the destination keystore will have the same alias names and protection passwords (for secret keys and private keys). If the <code class="codeph">keytool</code> command can???t recover the private keys or secret keys from the source keystore, then it prompts you for a password. If it detects alias duplication, then it asks you for a new alias, and you can specify a new alias or simply allow the <code class="codeph">keytool</code> command to overwrite the existing one.</p>
<p>For example, to import entries from a typical JKS type keystore <code class="codeph">key.jks</code> into a PKCS #11 type hardware-based keystore, use the command:</p>
<pre dir="ltr">keytool -importkeystore
    -srckeystore key.jks -destkeystore NONE
    -srcstoretype JKS -deststoretype PKCS11
    -srcstorepass <span class="variable">password</span>
    -deststorepass <span class="variable">password</span>
</pre>
<p>The <code class="codeph">importkeystore</code> command can also be used to import a single entry from a source keystore to a destination keystore. In this case, besides the options you see in the previous example, you need to specify the alias you want to import. With the <code class="codeph">-srcalias</code> option specified, you can also specify the destination alias name in the command line, as well as protection password for a secret or private key and the destination protection password you want. The following command demonstrates this:</p>
<pre dir="ltr">keytool -importkeystore
    -srckeystore key.jks -destkeystore NONE
    -srcstoretype JKS -deststoretype PKCS11
    -srcstorepass <span class="variable">password</span>
    -deststorepass <span class="variable">password</span>
    -srcalias myprivatekey -destalias myoldprivatekey
    -srckeypass <span class="variable">password</span>
    -destkeypass <span class="variable">password</span>
    -noprompt
</pre></div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__EXAMPLEOFGENERATINGCERTIFICATESFORA-9BB8A562">
<p class="subhead1">Example of Generating Certificates for an SSL Server</p>
<p>The following are <code class="codeph">keytool</code> commands to generate key pairs and certificates for three entities: Root CA (<code class="codeph">root</code>), Intermediate CA (<code class="codeph">ca</code>), and SSL server (<code class="codeph">server</code>). Ensure that you store all the certificates in the same keystore. In these examples, RSA is the recommended the key algorithm.</p>
<pre dir="ltr">keytool -genkeypair -keystore root.jks -alias root -ext bc:c
keytool -genkeypair -keystore ca.jks -alias ca -ext bc:c
keytool -genkeypair -keystore server.jks -alias server

keytool -keystore root.jks -alias root -exportcert -rfc &gt; root.pem

keytool -storepass <span class="variable">password</span> -keystore ca.jks -certreq -alias ca |
keytool -storepass <span class="variable">password</span> -keystore root.jks
-gencert -alias root -ext BC=0 -rfc &gt; ca.pem
keytool -keystore ca.jks -importcert -alias ca -file ca.pem

keytool -storepass <span class="variable">password</span> -keystore server.jks -certreq -alias server |
keytool -storepass <span class="variable">password</span> -keystore ca.jks -gencert -alias ca
-ext ku:c=dig,kE -rfc &gt; server.pem
cat root.pem ca.pem server.pem |
keytool -keystore server.jks -importcert -alias server
</pre></div>
<!-- class="section" -->
<div class="section">
<p class="subhead1">Terms</p>
<dl>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-911FFF69-6916-4C69-8A93-66A13E4A239C"><!-- --></a>Keystore</dt>
<dd>
<p>A keystore is a storage facility for cryptographic keys and certificates.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-5B627F3A-1831-4204-BF50-484CFE3BD71F"><!-- --></a>Keystore entries</dt>
<dd>
<p>Keystores can have different types of entries. The two most applicable entry types for the <code class="codeph">keytool</code> command include the following:</p>
<p><span class="bold">Key entries</span>: Each entry holds very sensitive cryptographic key information, which is stored in a protected format to prevent unauthorized access. Typically, a key stored in this type of entry is a secret key, or a private key accompanied by the certificate chain for the corresponding public key. See <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDFDJDH">"Certificate Chains"</a>. The <code class="codeph">keytool</code> command can handle both types of entries, while the <code class="codeph">jarsigner</code> tool only handles the latter type of entry, that is private keys and their associated certificate chains.</p>
<p><span class="bold">Trusted certificate entries</span>: Each entry contains a single public key certificate that belongs to another party. The entry is called a trusted certificate because the keystore owner trusts that the public key in the certificate belongs to the identity identified by the subject (owner) of the certificate. The issuer of the certificate vouches for this, by signing the certificate.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDJHCAA"><!-- --></a>Keystore aliases</dt>
<dd>
<p>All keystore entries (key and trusted certificate entries) are accessed by way of unique aliases.</p>
<p>An alias is specified when you add an entity to the keystore with the <code class="codeph">-genseckey</code> command to generate a secret key, the <code class="codeph">-genkeypair</code> command to generate a key pair (public and private key), or the <code class="codeph">-importcert</code> command to add a certificate or certificate chain to the list of trusted certificates. Subsequent <code class="codeph">keytool</code> commands must use this same alias to refer to the entity.</p>
<p>For example, you can use the alias <code class="codeph">duke</code> to generate a new public/private key pair and wrap the public key into a self-signed certificate with the following command. See <span class="bold">Certificate Chains</span>.</p>
<pre dir="ltr">keytool -genkeypair -alias duke -keypass dukekeypasswd
</pre>
<p>This example specifies an initial password of <code class="codeph">dukekeypasswd</code> required by subsequent commands to access the private key associated with the alias <code class="codeph">duke</code>. If you later want to change Duke's private key password, use a command such as the following:</p>
<pre dir="ltr">keytool -keypasswd -alias duke -keypass dukekeypasswd -new newpass
</pre>
<p>This changes the password from <code class="codeph">dukekeypasswd</code> to <code class="codeph">newpass</code>. A password shouldn???t be specified on a command line or in a script unless it is for testing purposes, or you are on a secure system. If you don???t specify a required password option on a command line, then you are prompted for it.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-A8B9E662-C1C2-4A0E-9307-A8464F0E95D4"><!-- --></a>Keystore implementation</dt>
<dd>
<p>The <code class="codeph">KeyStore</code> class provided in the <code class="codeph">java.security</code> package supplies well-defined interfaces to access and modify the information in a keystore. It is possible for there to be multiple different concrete implementations, where each implementation is that for a particular type of keystore.</p>
<p>Currently, two command-line tools (<code class="codeph">keytool</code> and <code class="codeph">jarsigner</code>) and a GUI-based tool named Policy Tool make use of keystore implementations. Because the <code class="codeph">KeyStore</code> class is <code class="codeph">public</code>, users can write additional security applications that use it.</p>
<p>As of JDK 9, the default keystore implementation is <code class="codeph">PKCS12</code>. This is a cross platform keystore based on the RSA PKCS12 Personal Information Exchange Syntax Standard. This standard is primarily meant for storing or transporting a user's private keys, certificates, and miscellaneous secrets. There is another built-in implementation, provided by Oracle. It implements the keystore as a file with a proprietary keystore type (format) named <code class="codeph">JKS</code>. It protects each private key with its individual password, and also protects the integrity of the entire keystore with a (possibly different) password.</p>
<p>Keystore implementations are provider-based. More specifically, the application interfaces supplied by <code class="codeph">KeyStore</code> are implemented in terms of a Service Provider Interface (SPI). That is, there is a corresponding abstract <code class="codeph">KeystoreSpi</code> class, also in the <code class="codeph">java.security package</code>, which defines the Service Provider Interface methods that providers must implement. The term <span class="italic">provider</span> refers to a package or a set of packages that supply a concrete implementation of a subset of services that can be accessed by the Java Security API. To provide a keystore implementation, clients must implement a provider and supply a <code class="codeph">KeystoreSpi</code> subclass implementation, as described in <a class="olink JSSEC-GUID-CC161921-EBD2-48C6-B543-A956658B68B6" target="_blank" href="../security/howtoimplaprovider.htm#JSSEC-GUID-CC161921-EBD2-48C6-B543-A956658B68B6">Steps to Implement and Integrate a Provider</a>.</p>
<p>Applications can choose different types of keystore implementations from different providers, using the <code class="codeph">getInstance</code> factory method supplied in the <code class="codeph">KeyStore</code> class. A keystore type defines the storage and data format of the keystore information, and the algorithms used to protect private/secret keys in the keystore and the integrity of the keystore. Keystore implementations of different types aren???t compatible.</p>
<p>The <code class="codeph">keytool</code> command works on any file-based keystore implementation. It treats the keystore location that is passed to it at the command line as a file name and converts it to a <code class="codeph">FileInputStream</code>, from which it loads the keystore information.)The <code class="codeph">jarsigner</code> and <code class="codeph">policytool</code> commands can read a keystore from any location that can be specified with a URL.</p>
<p>For <code class="codeph">keytool</code> and <code class="codeph">jarsigner</code>, you can specify a keystore type at the command line, with the <code class="codeph">-storetype</code> option. For Policy Tool, you can specify a keystore type with the <span class="bold">Keystore</span> menu.</p>
<p>If you don???t explicitly specify a keystore type, then the tools choose a keystore implementation based on the value of the <code class="codeph">keystore.type</code> property specified in the security properties file. The security properties file is called <code class="codeph">java.security</code>, and resides in the security properties directory:</p>
<ul style="list-style-type: disc;">
<li>
<p style="margin: 0px;"><span class="bold"><span>Oracle Solaris, Linux, and OS X</span>:</span>: <code class="codeph"><span class="codeinlineitalic">java.home</span>/lib/security</code></p>
</li>
<li>
<p style="margin: 0px;"><span class="bold">Windows</span>: <code class="codeph">java.home\lib\security</code></p>
</li>
</ul>
<p>Each tool gets the <code class="codeph">keystore.type</code> value and then examines all the currently installed providers until it finds one that implements a keystores of that type. It then uses the keystore implementation from that provider.The <code class="codeph">KeyStore</code> class defines a static method named <code class="codeph">getDefaultType</code> that lets applications and applets retrieve the value of the <code class="codeph">keystore.type</code> property. The following line of code creates an instance of the default keystore type as specified in the <code class="codeph">keystore.type</code> property:</p>
<pre dir="ltr">KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
</pre>
<p>The default keystore type is <code class="codeph">pkcs12</code>, which is a cross-platform keystore based on the RSA PKCS12 Personal Information Exchange Syntax Standard. This is specified by the following line in the security properties file:</p>
<pre dir="ltr">keystore.type=pkcs12
</pre>
<p>To have the tools utilize a keystore implementation other than the default, you can change that line to specify a different keystore type. For example, if you want to use the Oracle's <code class="codeph">jks</code> keystore implementation, then change the line to the following:</p>
<pre dir="ltr">keystore.type=jks
</pre>
<p><span class="bold">Note:</span> Case doesn???t matter in keystore type designations. For example, <code class="codeph">JKS</code> would be considered the same as jks.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDHHEFI"><!-- --></a>Certificate</dt>
<dd>
<p>A certificate (or public-key certificate) is a digitally signed statement from one entity (the issuer), saying that the public key and some other information of another entity (the subject) has some specific value. The following terms are related to certificates:</p>
<p><span class="bold">Public Keys</span>: These are numbers associated with a particular entity, and are intended to be known to everyone who needs to have trusted interactions with that entity. Public keys are used to verify signatures.</p>
<p><span class="bold">Digitally Signed</span>: If some data is digitally signed, then it is stored with the identity of an entity and a signature that proves that entity knows about the data. The data is rendered unforgeable by signing with the entity's private key.</p>
<p><span class="bold">Identity</span>: A known way of addressing an entity. In some systems, the identity is the public key, and in others it can be anything from an Oracle Solaris UID to an email address to an X.509 distinguished name.</p>
<p><span class="bold">Signature</span>: A signature is computed over some data using the private key of an entity. The signer, which in the case of a certificate is also known as the issuer.</p>
<p><span class="bold">Private Keys</span>: These are numbers, each of which is supposed to be known only to the particular entity whose private key it is (that is, it is supposed to be kept secret). Private and public keys exist in pairs in all public key cryptography systems (also referred to as public key crypto systems). In a typical public key crypto system, such as DSA, a private key corresponds to exactly one public key. Private keys are used to compute signatures.</p>
<p><span class="bold">Entity</span>: An entity is a person, organization, program, computer, business, bank, or something else you are trusting to some degree.</p>
<p>Public key cryptography requires access to users' public keys. In a large-scale networked environment, it is impossible to guarantee that prior relationships between communicating entities were established or that a trusted repository exists with all used public keys. Certificates were invented as a solution to this public key distribution problem. Now a Certification Authority (CA) can act as a trusted third party. CAs are entities such as businesses that are trusted to sign (issue) certificates for other entities. It is assumed that CAs only create valid and reliable certificates because they are bound by legal agreements. There are many public Certification Authorities, such as VeriSign, Thawte, Entrust, and so on.</p>
<p>You can also run your own Certification Authority using products such as Microsoft Certificate Server or the Entrust CA product for your organization. With the <code class="codeph">keytool</code> command, it is possible to display, import, and export certificates. It is also possible to generate self-signed certificates.</p>
<p>The <code class="codeph">keytool</code> command currently handles X.509 certificates.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__GUID-6567FF8E-7B38-4C56-A423-B5D42154E153"><!-- --></a>X.509 Certificates</dt>
<dd>
<p>The X.509 standard defines what information can go into a certificate and describes how to write it down (the data format). All the data in a certificate is encoded with two related standards called ASN.1/DER. Abstract Syntax Notation 1 describes data. The Definite Encoding Rules describe a single way to store and transfer that data.</p>
<p>All X.509 certificates have the following data, in addition to the signature:</p>
<p><span class="bold">Version</span>: This identifies which version of the X.509 standard applies to this certificate, which affects what information can be specified in it. Thus far, three versions are defined. The <code class="codeph">keytool</code> command can import and export v1, v2, and v3 certificates. It generates v3 certificates.</p>
<p>X.509 Version 1 has been available since 1988, is widely deployed, and is the most generic.</p>
<p>X.509 Version 2 introduced the concept of subject and issuer unique identifiers to handle the possibility of reuse of subject or issuer names over time. Most certificate profile documents strongly recommend that names not be reused and that certificates shouldn???t make use of unique identifiers. Version 2 certificates aren???t widely used.</p>
<p>X.509 Version 3 is the most recent (1996) and supports the notion of extensions where anyone can define an extension and include it in the certificate. Some common extensions are: KeyUsage (limits the use of the keys to particular purposes such as <code class="codeph">signing-only</code>) and AlternativeNames (allows other identities to also be associated with this public key, for example. DNS names, email addresses, IP addresses). Extensions can be marked critical to indicate that the extension should be checked and enforced or used. For example, if a certificate has the KeyUsage extension marked critical and set to <code class="codeph">keyCertSign</code>, then when this certificate is presented during SSL communication, it should be rejected because the certificate extension indicates that the associated private key should only be used for signing certificates and not for SSL use.</p>
<p><span class="bold">Serial number</span>: The entity that created the certificate is responsible for assigning it a serial number to distinguish it from other certificates it issues. This information is used in numerous ways. For example, when a certificate is revoked its serial number is placed in a Certificate Revocation List (CRL).</p>
<p><span class="bold">Signature algorithm identifier</span>: This identifies the algorithm used by the CA to sign the certificate.</p>
<p><span class="bold">Issuer name</span>: The X.500 Distinguished Name of the entity that signed the certificate. See <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDHBFGJ">"X.500 Distinguished Names"</a>. This is typically a CA. Using this certificate implies trusting the entity that signed this certificate. In some cases, such as root or top-level CA certificates, the issuer signs its own certificate.</p>
<p><span class="bold">Validity period</span>: Each certificate is valid only for a limited amount of time. This period is described by a start date and time and an end date and time, and can be as short as a few seconds or almost as long as a century. The validity period chosen depends on a number of factors, such as the strength of the private key used to sign the certificate, or the amount one is willing to pay for a certificate. This is the expected period that entities can rely on the public value, when the associated private key has not been compromised.</p>
<p><span class="bold">Subject name</span>: The name of the entity whose public key the certificate identifies. This name uses the X.500 standard, so it is intended to be unique across the Internet. This is the X.500 Distinguished Name (DN) of the entity. For example,</p>
<pre dir="ltr">CN=Java Duke, OU=Java Software Division, O=Oracle Corporation, C=US
</pre>
<p>These refer to the subject's common name (CN), organizational unit (OU), organization (O), and country (C).</p>
<p><span class="bold">Subject public key information</span>: This is the public key of the entity being named with an algorithm identifier that specifies which public key crypto system this key belongs to and any associated key parameters.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDFDJDH"><!-- --></a>Certificate Chains</dt>
<dd>
<p>The <code class="codeph">keytool</code> command can create and manage keystore key entries that each contain a private key and an associated certificate chain. The first certificate in the chain contains the public key that corresponds to the private key.</p>
<p>When keys are first generated, the chain starts off containing a single element, a self-signed certificate. See <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_GENKEYPAIR">"-genkeypair"</a> in <span class="bold">Commands</span>. A self-signed certificate is one for which the issuer (signer) is the same as the subject. The subject is the entity whose public key is being authenticated by the certificate. Whenever the <code class="codeph">-genkeypair</code> command is called to generate a new public/private key pair, it also wraps the public key into a self-signed certificate.</p>
<p>Later, after a Certificate Signing Request (CSR) was generated with the <code class="codeph">-certreq</code> command and sent to a Certification Authority (CA), the response from the CA is imported with <code class="codeph">-importcert</code>, and the self-signed certificate is replaced by a chain of certificates. See <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_CERTREQ">"-certreq"</a> and <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__KEYTOOL_OPTION_IMPORTCERT">"-importcert"</a> options in <span class="bold">Commands</span>. At the bottom of the chain is the certificate (reply) issued by the CA authenticating the subject's public key. The next certificate in the chain is one that authenticates the CA's public key.</p>
<p>In many cases, this is a self-signed certificate, which is a certificate from the CA authenticating its own public key, and the last certificate in the chain. In other cases, the CA might return a chain of certificates. In this case, the bottom certificate in the chain is the same (a certificate signed by the CA, authenticating the public key of the key entry), but the second certificate in the chain is a certificate signed by a different CA that authenticates the public key of the CA you sent the CSR to. The next certificate in the chain is a certificate that authenticates the second CA's key, and so on, until a self-signed root certificate is reached. Each certificate in the chain (after the first) authenticates the public key of the signer of the previous certificate in the chain.</p>
<p>Many CAs only return the issued certificate, with no supporting chain, especially when there is a flat hierarchy (no intermediates CAs). In this case, the certificate chain must be established from trusted certificate information already stored in the keystore.</p>
<p>A different reply format (defined by the PKCS #7 standard) includes the supporting certificate chain in addition to the issued certificate. Both reply formats can be handled by the <code class="codeph">keytool</code> command.</p>
<p>The top-level (root) CA certificate is self-signed. However, the trust into the root's public key doesn???t come from the root certificate itself, but from other sources such as a newspaper. This is because anybody could generate a self-signed certificate with the distinguished name of, for example, the VeriSign root CA. The root CA public key is widely known. The only reason it is stored in a certificate is because this is the format understood by most tools, so the certificate in this case is only used as a vehicle to transport the root CA's public key. Before you add the root CA certificate to your keystore, you should view it with the <code class="codeph">-printcert</code> option and compare the displayed fingerprint with the well-known fingerprint obtained from a newspaper, the root CA's Web page, and so on.</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CACERTS"><!-- --></a>The cacerts Certificates File</dt>
<dd>
<p>A certificates file named <code class="codeph">cacerts</code> resides in the security properties directory:</p>
<ul style="list-style-type: disc;">
<li>
<p style="margin: 0px;"><span class="bold"><span>Oracle Solaris, Linux, and OS X</span>:</span>: <code class="codeph"><span class="codeinlineitalic">JAVA_HOME&nbsp;</span>/lib/security</code></p>
</li>
<li>
<p style="margin: 0px;"><span class="bold">Windows</span>: <code class="codeph">java.home\lib\security</code></p>
</li>
</ul>
<p><code class="codeph">java.home</code> is the runtime environment directory, which is the <code class="codeph">jre</code> directory in the JDK or the top-level directory of the Java Runtime Environment (JRE).</p>
<p>The <code class="codeph">cacerts</code> file represents a system-wide keystore with CA certificates. System administrators can configure and manage that file with the <code class="codeph">keytool</code> command by specifying <code class="codeph">jks</code> as the keystore type. The <code class="codeph">cacerts</code> keystore file ships with a default set of root CA certificates. For Oracle Solaris, Linux, OS X, and Windows, you can list the default certificates with the following command:</p>
<pre dir="ltr">keytool -list -cacerts 
</pre>
<p>The initial password of the <code class="codeph">cacerts</code> keystore file is <code class="codeph">changeit</code>. System administrators should change that password and the default access permission of that file upon installing the SDK.</p>
<p><span class="bold">Note:</span> It is important to verify your <code class="codeph">cacerts</code> file. Because you trust the CAs in the <code class="codeph">cacerts</code> file as entities for signing and issuing certificates to other entities, you must manage the <code class="codeph">cacerts</code> file carefully. The <code class="codeph">cacerts</code> file should contain only certificates of the CAs you trust. It is your responsibility to verify the trusted root CA certificates bundled in the <code class="codeph">cacerts</code> file and make your own trust decisions.</p>
<p>To remove an untrusted CA certificate from the <code class="codeph">cacerts</code> file, use the <code class="codeph">delete</code> option of the <code class="codeph">keytool</code> command. You can find the <code class="codeph">cacerts</code> file in the JRE installation directory. Contact your system administrator if you don???t have permission to edit this file</p>
</dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDGGFEG"><!-- --></a>Internet RFC 1421 Certificate Encoding Standard</dt>
<dd>
<p>Certificates are often stored using the printable encoding format defined by the Internet RFC 1421 standard, instead of their binary encoding. This certificate format, also known as Base64 encoding, makes it easy to export certificates to other applications by email or through some other mechanism.</p>
<p>Certificates read by the <code class="codeph">-importcert</code> and <code class="codeph">-printcert</code> commands can be in either this format or binary encoded. The <code class="codeph">-exportcert</code> command by default outputs a certificate in binary encoding, but will instead output a certificate in the printable encoding format, when the <code class="codeph">-rfc</code> option is specified.</p>
<p>The <code class="codeph">-list</code> command by default prints the SHA-256 fingerprint of a certificate. If the <code class="codeph">-v</code> option is specified, then the certificate is printed in human-readable format. If the <code class="codeph">-rfc</code> option is specified, then the certificate is output in the printable encoding format.</p>
<p>In its printable encoding format, the encoded certificate is bounded at the beginning and end by the following text:</p>
<pre dir="ltr">-----BEGIN CERTIFICATE-----

encoded certificate goes here.

-----END CERTIFICATE-----
</pre></dd>
<dt class="dlterm"><a id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDHBFGJ"><!-- --></a>X.500 Distinguished Names</dt>
<dd>
<p>X.500 Distinguished Names are used to identify entities, such as those that are named by the <code class="codeph">subject</code> and <code class="codeph">issuer</code> (signer) fields of X.509 certificates. The <code class="codeph">keytool</code> command supports the following subparts:</p>
<p><span class="bold">commonName</span>: The common name of a person such as Susan Jones.</p>
<p><span class="bold">organizationUnit</span>: The small organization (such as department or division) name. For example, Purchasing.</p>
<p><span class="bold">localityName</span>: The locality (city) name, for example, Palo Alto.</p>
<p><span class="bold">stateName</span>: State or province name, for example, California.</p>
<p><span class="bold">country</span>: Two-letter country code, for example, CH.</p>
<p>When you supply a distinguished name string as the value of a <code class="codeph">-dname</code> option, such as for the <code class="codeph">-genkeypair</code> command, the string must be in the following format:</p>
<pre dir="ltr">CN=cName, OU=orgUnit, O=org, L=city, S=state, C=countryCode
</pre>
<p>All the following items represent actual values and the previous keywords are abbreviations for the following:</p>
<pre dir="ltr">CN=commonName
OU=organizationUnit
O=organizationName
L=localityName
S=stateName
C=country
</pre>
<p>A sample distinguished name string is:</p>
<pre dir="ltr">CN=Mark Smith, OU=Java, O=Oracle, L=Cupertino, S=California, C=US
</pre>
<p>A sample command using such a string is:</p>
<pre dir="ltr">keytool -genkeypair -dname "CN=Mark Smith, OU=Java, O=Oracle, L=Cupertino,
S=California, C=US" -alias mark
</pre>
<p>Case doesn???t matter for the keyword abbreviations. For example, CN, cn, and Cn are all treated the same.</p>
<p>Order matters; each subcomponent must appear in the designated order. However, it isn???t necessary to have all the subcomponents. You can use a subset, for example:</p>
<pre dir="ltr">CN=Smith, OU=Java, O=Oracle, C=US
</pre>
<p>If a distinguished name string value contains a comma, then the comma must be escaped by a backslash (\) character when you specify the string on a command line, as in:</p>
<pre dir="ltr">cn=Jack, ou=Java\, Product Development, o=Oracle, c=US
</pre>
<p>It is never necessary to specify a distinguished name string on a command line. When the distinguished name is needed for a command, but not supplied on the command line, the user is prompted for each of the subcomponents. In this case, a comma doesn???t need to be escaped by a backslash (\).</p>
</dd>
</dl>
</div>
<!-- class="section" -->
<div class="section">
<p class="subhead1">Warnings</p>
</div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDEBFCI">
<p class="subhead1">Importing Trusted Certificates Warning</p>
<p><span class="bold">Important</span>: Be sure to check a certificate very carefully before importing it as a trusted certificate.</p>
<p><span class="bold">Windows Example:</span></p>
<p>View the certificate first with the <code class="codeph">-printcert</code> command or the <code class="codeph">-importcert</code> command without the <code class="codeph">-noprompt</code> option. Ensure that the displayed certificate fingerprints match the expected ones. For example, suppose someone sends or emails you a certificate that you put it in a file named <code class="codeph">\tmp\cert</code>. Before you consider adding the certificate to your list of trusted certificates, you can execute a <code class="codeph">-printcert</code> command to view its fingerprints, as follows:</p>
<pre dir="ltr">  keytool -printcert -file \tmp\cert
    Owner: CN=ll, OU=ll, O=ll, L=ll, S=ll, C=ll
    Issuer: CN=ll, OU=ll, O=ll, L=ll, S=ll, C=ll
    Serial Number: 59092b34
    Valid from: Thu Jun 24 18:01:13 PDT 2016 until: Wed Jun 23 17:01:13 PST 2016
    Certificate Fingerprints:

                   SHA-1: 20:B6:17:FA:EF:E5:55:8A:D0:71:1F:E8:D6:9D:C0:37:13:0E:5E:FE 
                 SHA-256: 90:7B:70:0A:EA:DC:16:79:92:99:41:FF:8A:FE:EB:90:
                          17:75:E0:90:B2:24:4D:3A:2A:16:A6:E4:11:0F:67:A4
</pre>
<p><span class="bold">Oracle Solaris Example:</span></p>
<p>View the certificate first with the <code class="codeph">-printcert</code> command or the <code class="codeph">-importcert</code> command without the <code class="codeph">-noprompt</code> option. Ensure that the displayed certificate fingerprints match the expected ones. For example, suppose someone sends or emails you a certificate that you put it in a file named <code class="codeph">/tmp/cert</code>. Before you consider adding the certificate to your list of trusted certificates, you can execute a <code class="codeph">-printcert</code> command to view its fingerprints, as follows:</p>
<pre dir="ltr">  keytool -printcert -file /tmp/cert
    Owner: CN=ll, OU=ll, O=ll, L=ll, S=ll, C=ll
    Issuer: CN=ll, OU=ll, O=ll, L=ll, S=ll, C=ll
    Serial Number: 59092b34
    Valid from: Thu Jun 24 18:01:13 PDT 2016 until: Wed Jun 23 17:01:13 PST 2016
    Certificate Fingerprints:

                   SHA-1: 20:B6:17:FA:EF:E5:55:8A:D0:71:1F:E8:D6:9D:C0:37:13:0E:5E:FE 
                   SHA-256: 90:7B:70:0A:EA:DC:16:79:92:99:41:FF:8A:FE:EB:90:
                           17:75:E0:90:B2:24:4D:3A:2A:16:A6:E4:11:0F:67:A4
</pre>
<p>Then call or otherwise contact the person who sent the certificate and compare the fingerprints that you see with the ones that they show. Only when the fingerprints are equal is it guaranteed that the certificate wasn???t replaced in transit with somebody else's certificate such as an attacker's certificate. If such an attack took place, and you didn???t check the certificate before you imported it, then you would be trusting anything the attacker signed, for example, a JAR file with malicious class files inside.</p>
<p><span class="bold">Note:</span> It isn???t required that you execute a <code class="codeph">-printcert</code> command before importing a certificate. This is because before you add a certificate to the list of trusted certificates in the keystore, the <code class="codeph">-importcert</code> command prints out the certificate information and prompts you to verify it. You can then stop the import operation. However, you can do this only when you call the <code class="codeph">-importcert</code> command without the <code class="codeph">-noprompt</code> option. If the <code class="codeph">-noprompt</code> option is specified, then there is no interaction with the user.</p>
</div>
<!-- class="section" -->
<div class="section">
<p class="subhead1">Passwords Warning</p>
<p>Most commands that operate on a keystore require the store password. Some commands require a private/secret key password. Passwords can be specified on the command line in the <code class="codeph">-storepass</code> and <code class="codeph">-keypass</code> options. However, a password shouldn???t be specified on a command line or in a script unless it is for testing, or you are on a secure system. When you don???t specify a required password option on a command line, you are prompted for it.</p>
</div>
<!-- class="section" -->
<div class="section" id="GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CHDCJBCI">
<p class="subhead1">Certificate Conformance Warning</p>
<p><a href="https://tools.ietf.org/rfc/rfc5280.txt" target="_blank">Internet X.509 Public Key Infrastructure Certificate and Certificate Revocation List (CRL) Profile</a> defined a profile on conforming X.509 certificates, which includes what values and value combinations are valid for certificate fields and extensions.</p>
<p>The <code class="codeph">keytool</code> command doesn???t enforce all of these rules so it can generate certificates that don???t conform to the standard, such as self-signed certificates that would be used for internal testing purposes. Certificates that don???t conform to the standard might be rejected by JRE or other applications. Users should ensure that they provide the correct options for <code class="codeph">-dname</code>, <code class="codeph">-ext</code>, and so on.</p>
</div>
<!-- class="section" -->
<div class="section">
<p class="subhead1">Import a New Trusted Certificate</p>
<p>Before you add the certificate to the keystore, the <code class="codeph">keytool</code> command verifies it by attempting to construct a chain of trust from that certificate to a self-signed certificate (belonging to a root CA), using trusted certificates that are already available in the keystore.</p>
<p>If the <code class="codeph">-trustcacerts</code> option was specified, then additional certificates are considered for the chain of trust, namely the certificates in a file named <code class="codeph">cacerts</code>.</p>
<p>If the <code class="codeph">keytool</code> command fails to establish a trust path from the certificate to be imported up to a self-signed certificate (either from the keystore or the <code class="codeph">cacerts</code> file), then the certificate information is printed, and the user is prompted to verify it by comparing the displayed certificate fingerprints with the fingerprints obtained from some other (trusted) source of information, which might be the certificate owner. Be very careful to ensure the certificate is valid before importing it as a trusted certificate. The user then has the option of stopping the import operation. If the <code class="codeph">-noprompt</code> option is specified, then there is no interaction with the user.</p>
</div>
<!-- class="section" -->
<div class="section">
<p class="subhead1">Import a Certificate Reply</p>
<p>When you import a certificate reply, the certificate reply is validated with trusted certificates from the keystore, and optionally, the certificates configured in the <code class="codeph">cacerts</code> keystore file when the <code class="codeph">-trustcacert</code><code class="codeph">s</code> option is specified. See <a href="keytool.htm#GUID-5990A2E4-78E3-47B7-AE75-6D1826259549__CACERTS">"The cacerts Certificates File"</a>.</p>
<p>The methods of determining whether the certificate reply is trusted are as follows:</p>
<ul style="list-style-type: disc;">
<li>
<p>If the reply is a single X.509 certificate, then the <code class="codeph">keytool</code> command attempts to establish a trust chain, starting at the certificate reply and ending at a self-signed certificate (belonging to a root CA). The certificate reply and the hierarchy of certificates is used to authenticate the certificate reply from the new certificate chain of aliases. If a trust chain can???t be established, then the certificate reply isn???t imported. In this case, the <code class="codeph">keytool</code> command doesn???t print the certificate and prompt the user to verify it, because it is very difficult for a user to determine the authenticity of the certificate reply.</p>
</li>
<li>
<p>If the reply is a PKCS #7 formatted certificate chain or a sequence of X.509 certificates, then the chain is ordered with the user certificate first followed by zero or more CA certificates. If the chain ends with a self-signed root CA certificate and the <code class="codeph">-trustcacerts</code> option was specified, the <code class="codeph">keytool</code> command attempts to match it with any of the trusted certificates in the keystore or the <code class="codeph">cacerts</code> keystore file. If the chain doesn???t end with a self-signed root CA certificate and the <code class="codeph">-trustcacerts</code> option was specified, the <code class="codeph">keytool</code> command tries to find one from the trusted certificates in the keystore or the <code class="codeph">cacerts</code> keystore file and add it to the end of the chain. If the certificate isn???t found and the <code class="codeph">-noprompt</code> option isn???t specified, the information of the last certificate in the chain is printed, and the user is prompted to verify it.</p>
</li>
</ul>
<p>If the public key in the certificate reply matches the user's public key already stored with <code class="codeph">alias</code>, then the old certificate chain is replaced with the new certificate chain in the reply. The old chain can only be replaced with a valid <code class="codeph">keypass</code>, and so the password used to protect the private key of the entry is supplied. If no password is provided, and the private key password is different from the keystore password, the user is prompted for it.</p>
<p>This command was named <code class="codeph">-import</code> in earlier releases. This old name is still supported in this release. The new name, <code class="codeph">-importcert</code>, is preferred going forward.</p>
</div>
<!-- class="section" --></div>
<div id="bar3" class="border-top glyph" style="position: relative; text-align: center;"></div></div>