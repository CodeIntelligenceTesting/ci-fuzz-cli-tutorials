import { FuzzedDataProvider } from "@jazzer.js/core";
import { exploreMe } from "./ExploreMe";

test.fuzz("My fuzz test", (jazzerBuffer: Buffer) => {
	const provider: FuzzedDataProvider = new FuzzedDataProvider(jazzerBuffer);
	const a: number = provider.consumeNumber();
	const b: number = provider.consumeNumber();
	const c: string = provider.consumeString(8);

	exploreMe(a, b, c);
});
