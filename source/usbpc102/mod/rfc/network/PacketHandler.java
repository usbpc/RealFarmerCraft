package usbpc102.mod.rfc.network;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	public PacketHandler() {
	}

	@Override
	//Standert Methode vom Meinem Packet HAndler, der z.Z noch nicht benutzt wird, aber eingerichtet ist.
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

	}

}
