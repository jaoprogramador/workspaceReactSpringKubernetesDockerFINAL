import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  reactStrictMode: true,
  swcMinify: true,
  serverRuntimeConfig: {
    API_BASE_URL: process.env.SERVER_SIDE_API_BASE_URL
  },
  publicRuntimeConfig: {
    API_BASE_URL: process.env.CLIENT_SIDE_API_BASE_URL
  },
  async redirects() {
    return [
      // Basic redirect
      {
        source: '/',
        destination: '/bookmarks',
        permanent: true,
      },
      
    ]
  }
  
};

//module.exports = nextConfig
export default nextConfig;
