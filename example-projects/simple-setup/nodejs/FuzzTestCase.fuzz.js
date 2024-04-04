const { FuzzedDataProvider } = require("@jazzer.js/core");
const exploreMe = require("./ExploreMe");

test.fuzz("My fuzz test", jazzerBuffer => {
	const provider = new FuzzedDataProvider(jazzerBuffer);
	const a = provider.consumeNumber();
	const b = provider.consumeNumber();
	const c = provider.consumeString(8);

	exploreMe(a, b, c);
});
