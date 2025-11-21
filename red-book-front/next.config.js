/** @type {import('next').NextConfig} */
const nextConfig = {
	redirects() {
		return [
			{
				source: "/",
				destination: "/example",
				permanent: true
			}
		];
	}
};

module.exports = nextConfig;
